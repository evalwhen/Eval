package com.eval.interpreter.parser.Ast;

import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.parser.InvalidSyntaxException;

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

  public NodeType getType() {
    return type;
  }

  public Expression toExpr(AstVistor ask) throws InvalidSyntaxException {
    return ask.visit(this);
  }

  public List<Ast> getElts() {
    return elts;
  }

  public String getLetVarName() {
    Node binding = (Node)this.getElts().get(0);
    Leaf varNameLeaf = (Leaf)binding.getElts().get(0);
    return varNameLeaf.getTok();
  }

  public Ast getLetValNode() {
    Node binding = (Node)this.getElts().get(0);
    return binding.getElts().get(1);
  }

  public Ast getLetBody() {

    return this.getElts().get(1);
  }

  public Ast getDiffEx1() {
    return this.getElts().get(0);
  }

  public Ast getDiffEx2() {
    return this.getElts().get(1);
  }

}
