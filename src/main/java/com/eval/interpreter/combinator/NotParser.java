package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Token;

import java.util.List;

public class NotParser extends Parser {
  private Parser p;

  public ParseResult parse(List<Token> toks, Continuation cont) {
    return p.parse(toks, new NotCont(toks, cont));
  }

  public NotParser(Parser p) {
    this.p = p;
  }
}
