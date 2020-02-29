package com.eval.interpreter.parser;

public class Leaf extends Ast {
  NodeType type;
  String tok;

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

  NodeType getType() {
    return type;
  }
}
