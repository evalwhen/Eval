package com.eval.interpreter.combinator;

public class NotParser extends Parser {
  Parser p;

  public ParseResult parse(String toks, Continuation cont) {
    return p.parse(toks, new NotCont(toks, cont));
  }

  public NotParser(Parser p) {
    this.p = p;
  }
}
