package com.eval.interpreter.parser;

import java.util.List;

public class OrCont extends Continuation {
  List<Parser> ps;
  String toks;
  Continuation savedCont;

  public OrCont(List<Parser> ps, String toks, Continuation savedCont) {
    this.ps = ps;
    this.toks = toks;
    this.savedCont = savedCont;
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

  ParseResult accept(ApplyContInterface ask) {
    return ask.visit(this);
  }
}
