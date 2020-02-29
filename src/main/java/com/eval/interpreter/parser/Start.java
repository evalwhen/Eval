package com.eval.interpreter.parser;

public class Start extends Parser {
  ParseResult parse(String toks, Continuation cont) {
    return newStartP().parse(toks, cont);
  }

  private Parser newStartP() {
    return new TagParser(Ast.NodeType.parens,new StringParser("("));
  }
}
