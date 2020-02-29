package com.eval.interpreter.parser;

public class End extends Parser{
  ParseResult parse(String toks, Continuation cont) {
    return newEndP().parse(toks, cont);
  }

  private Parser newEndP() {
    return new TagParser(Ast.NodeType.parens, new StringParser(")"));
  }
}
