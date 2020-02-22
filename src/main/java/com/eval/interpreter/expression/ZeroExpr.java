package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

class ZeroExpr extends Expression {
  private Expression expr;

  public ZeroExpr(Expression expr) {
    this.expr = expr;
  }

  public ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }

  public Expression getExpr() {
    return expr;
  }
}
