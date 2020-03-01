package com.eval.interpreter.parser;

import com.eval.interpreter.expression.Expression;

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

  public boolean isLetExpr() {
    // TODO: 逻辑过于复杂，需要重构
    if (this.getElts().size() == 3) {
      Ast l = this.getElts().get(0);
      if (l.getType() == NodeType.token) {
        return ((Leaf) l).getTok().equals("let");
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public String getLetVarName() {
    // TODO: 必须确保改方法是在 this Node 是 LetExpr 的情况下再去调用。
    Node binding = (Node) this.getElts().get(1);
    Leaf varNameNode = (Leaf) binding.getElts().get(0);
    return varNameNode.getTok();
  }

  public Ast getLetValNode() {
        // TODO: 必须确保改方法是在 this Node 是 LetExpr 的情况下再去调用。
    Node binding = (Node) this.getElts().get(1);
    return binding.getElts().get(1);
  }

  public Ast getLetBody() {

    return this.getElts().get(2);
  }

  public boolean isDiffExpr() {
    // TODO: 同 let expr.
    if (this.getElts().size() == 3) {
      Leaf l = (Leaf) this.getElts().get(0);
      if (l.getTok().equals("-")) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public Ast getDiffEx1() {
    return this.getElts().get(1);
  }

  public Ast getDiffEx2() {
    return this.getElts().get(2);
  }

}
