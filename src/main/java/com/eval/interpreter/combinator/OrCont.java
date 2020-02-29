package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Token;

import java.util.List;

public class OrCont extends Continuation {
  private List<Parser> ps;
  List<Token> toks;
  private Continuation savedCont;

  public OrCont(List<Parser> ps, List<Token> toks, Continuation savedCont) {
    this.ps = ps;
    this.toks = toks;
    this.savedCont = savedCont;
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

  ParseResult accept(ApplyContInterface ask) {
    return ask.visit(this);
  }
}
