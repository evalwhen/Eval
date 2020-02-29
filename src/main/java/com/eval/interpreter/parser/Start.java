package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.*;

import java.util.List;

public class Start extends Parser {
  public ParseResult parse(List<Token> toks, Continuation cont) {
    return newStartP().parse(toks, cont);
  }

  private Parser newStartP() {
    return new TagParser(Ast.NodeType.parens,new StringParser("("));
  }
}
