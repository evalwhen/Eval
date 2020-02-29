package com.eval.interpreter.parser;

public class TagCont extends Continuation {
  private Ast.NodeType type;
  private Continuation cont;

  public TagCont(Ast.NodeType type, Continuation cont) {
    this.type = type;
    this.cont = cont;
  }

  ParseResult accept(ApplyContInterface ask) {
    return ask.visit(this);
  }

  public Ast.NodeType getType() {
    return type;
  }

  public Continuation getCont() {
    return cont;
  }
}

