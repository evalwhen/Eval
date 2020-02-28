package com.eval.interpreter.parser;

public class NotCont extends Continuation {
  private String current_toks;
  private Continuation savedCont;

  public NotCont(String current_toks, Continuation savedCont) {
    this.current_toks = current_toks;
    this.savedCont = savedCont;
  }

  ParseResult accept(ContVI ask) {
    return ask.visit(this);
  }

  public String getCurrent_toks() {
    return current_toks;
  }

  public Continuation getSavedCont() {
    return savedCont;
  }
}

