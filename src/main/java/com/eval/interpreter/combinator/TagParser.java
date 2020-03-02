package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Ast.Ast;
import com.eval.interpreter.parser.Token;

import java.util.List;

public class TagParser extends Parser {
  private Ast.NodeType type;
  private Parser p;

  public TagParser(Ast.NodeType type, Parser p) {
    this.type = type;
    this.p = p;
  }

  public ParseResult parse(List<Token> toks, Continuation cont) {
    return p.parse(toks, new TagCont(type, cont));
  }

  public Ast.NodeType getType() {
    return type;
  }

  public Parser getP() {
    return p;
  }
}
