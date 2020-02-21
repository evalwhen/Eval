package com.eval.interpreter;

class ZeroExpr extends Expression {
  private Expression expr;

  public ZeroExpr(Expression expr) {
    this.expr = expr;
  }

  ExprValue Eval(ExprVisitorI ask) {
    return ask.visit(this);
  }
}
