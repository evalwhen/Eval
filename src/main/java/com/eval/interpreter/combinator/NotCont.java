package com.eval.interpreter.combinator;

public class NotCont extends Continuation {
  private String current_toks;
  private Continuation savedCont;

  public NotCont(String current_toks, Continuation savedCont) {
    this.current_toks = current_toks;
    this.savedCont = savedCont;
  }

  ParseResult accept(ApplyContInterface ask) {
    return ask.visit(this);
  }

  public String getCurrent_toks() {
    return current_toks;
  }

  public Continuation getSavedCont() {
    return savedCont;
  }
}

