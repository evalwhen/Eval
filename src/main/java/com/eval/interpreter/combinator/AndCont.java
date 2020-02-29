package com.eval.interpreter.combinator;

import java.util.List;

public class AndCont extends Continuation {
  private List<Parser> ps;
  private List<ParseResult> res;
  private String toks;
  private Continuation savedCont;

  public AndCont(List<Parser> ps, List<ParseResult> res, String toks, Continuation savedCont) {
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

  public String getToks() {
    return toks;
  }

  public Continuation getSavedCont() {
    return savedCont;
  }

  public List<ParseResult> getRes() {
    return res;
  }
}
