package com.eval.interpreter.parser;

import com.eval.interpreter.expression.*;

public class AstToExpr implements AstVistor{
  public Expression visit(Node n) throws InvalidSyntaxException {
    if (n.isLetExpr()) {
      return new LetExp(n.getLetVarName(), n.getLetValNode().toExpr(this), n.getLetBody().toExpr(this));
    } else if (n.isDiffExpr()) {
      return new DiffExpr(n.getDiffEx1().toExpr(this), n.getDiffEx2().toExpr(this));
    }
    else {
      throw new InvalidSyntaxException("无效的表达式语法！");
    }
  }

  public Expression visit(Leaf l) {
//    if (l.type == Ast.NodeType.number {
    if (isNumeric(l.getTok())) {
      return new ConstExpr(Integer.parseInt(l.getTok()));
    } else {
      return new VarExpr(l.getTok());
    }
  }

  private static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      double d = Integer.parseInt(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }
}
