package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.*;

public class End extends Parser {
  public ParseResult parse(String toks, Continuation cont) {
    return newEndP().parse(toks, cont);
  }

  private Parser newEndP() {
    return new TagParser(Ast.NodeType.parens, new StringParser(")"));
  }
}
