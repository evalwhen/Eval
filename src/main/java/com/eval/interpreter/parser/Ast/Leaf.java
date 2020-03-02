package com.eval.interpreter.parser.Ast;

import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.parser.InvalidSyntaxException;

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

  public Expression toExpr(AstVistor ask) throws InvalidSyntaxException {
    return ask.visit(this);
  }

  public String getTok() {
    return tok;
  }
}
