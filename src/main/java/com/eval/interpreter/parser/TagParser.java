package com.eval.interpreter.parser;

public class TagParser extends Parser {
  private Ast.NodeType type;
  private Parser p;

  public TagParser(Ast.NodeType type, Parser p) {
    this.type = type;
    this.p = p;
  }

  ParseResult parse(String toks, Continuation cont) {
    return p.parse(toks, new TagCont(type, cont));
  }

  public Ast.NodeType getType() {
    return type;
  }

  public Parser getP() {
    return p;
  }
}
