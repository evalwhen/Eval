package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.*;
import com.eval.interpreter.parser.Ast.Ast;

import java.util.List;

public class End extends Parser {
  public ParseResult parse(List<Token> toks, Continuation cont) {
    return newEndP().parse(toks, cont);
  }

  private Parser newEndP() {
    return new TagParser(Ast.NodeType.phantom, new StringParser(")"));
  }
}
