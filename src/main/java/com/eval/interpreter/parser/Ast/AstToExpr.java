package com.eval.interpreter.parser.Ast;

import com.eval.interpreter.expression.*;
import com.eval.interpreter.parser.InvalidSyntaxException;

public class AstToExpr implements AstVistor {
  public Expression visit(Node n) throws InvalidSyntaxException {
    switch (n.getType()) {
      case let:
        return new LetExp(n.getLetVarName(), n.getLetValNode().toExpr(this), n.getLetBody().toExpr(this));
      case diff:
        return new DiffExpr(n.getDiffEx1().toExpr(this), n.getDiffEx2().toExpr(this));
      default:
        throw new InvalidSyntaxException("无效的表达式！");
    }
  }

  public Expression visit(Leaf l) throws InvalidSyntaxException {
    switch (l.getType()) {
      case varname:
        return new VarExpr(l.getTok());
      case number:
        return new ConstExpr(Integer.parseInt(l.getTok()));
      default:
        throw new InvalidSyntaxException("无效的表达式！");
    }
  }
}
