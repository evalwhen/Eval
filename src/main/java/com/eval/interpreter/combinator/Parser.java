package com.eval.interpreter.combinator;

public abstract class Parser {
  public abstract ParseResult parse(String toks, Continuation cont);
}
