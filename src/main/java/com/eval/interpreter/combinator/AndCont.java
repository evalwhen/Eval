package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Token;

import java.util.List;

public class AndCont extends Continuation {
  private List<Parser> ps;
  private List<ParseResult> res;
  private List<Token> toks;
  private Continuation savedCont;

  public AndCont(List<Parser> ps, List<ParseResult> res, List<Token> toks, Continuation savedCont) {
    this.ps = ps;
    this.toks = toks;
    this.res = res;
    this.savedCont = savedCont;
  }

  ParseResult accept(ApplyContInterface ask) {
    return ask.visit(this);
  }

  public List<Parser> getPs() {
    return ps;
  }

  public List<Token> getToks() {
    return toks;
  }

  public Continuation getSavedCont() {
    return savedCont;
  }

  public List<ParseResult> getRes() {
    return res;
  }
}
