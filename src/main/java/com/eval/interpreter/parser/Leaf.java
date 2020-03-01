package com.eval.interpreter.parser;

import com.eval.interpreter.expression.Expression;

public class Leaf extends Ast {
  NodeType type;
  private String tok;

  public Leaf(NodeType type, String tok) {
    this.type = type;
    this.tok = tok;
  }

  @Override
  public String toString() {
    return "Leaf{" +
      "type=" + type +
      ", tok='" + tok + '\'' +
      '}';
  }

  public NodeType getType() {
    return type;
  }

  Expression toExpr(AstVistor ask) {
    return ask.visit(this);
  }

  public String getTok() {
    return tok;
  }
}
