package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Token;

import java.util.List;

public class NotCont extends Continuation {
  private List<Token> current_toks;
  private Continuation savedCont;

  public NotCont(List<Token> current_toks, Continuation savedCont) {
    this.current_toks = current_toks;
    this.savedCont = savedCont;
  }

  ParseResult accept(ApplyContInterface ask) {
    return ask.visit(this);
  }

  public List<Token> getCurrent_toks() {
    return current_toks;
  }

  public Continuation getSavedCont() {
    return savedCont;
  }
}

