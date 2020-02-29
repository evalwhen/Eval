package com.eval.interpreter.combinator;

import java.util.List;

public class Node extends Ast {
  NodeType type;
  List<Ast> elts;

  public Node(NodeType type, List<Ast> elts) {
    this.type = type;
    this.elts = elts;
  }

  @Override
  public String toString() {
    return "Node{" +
      "type=" + type +
      ", elts=" + elts +
      '}';
  }

  NodeType getType() {
    return type;
  }
}
