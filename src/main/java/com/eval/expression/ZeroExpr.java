package com.eval.expression;

class ZeroExpr extends Expression {
  private Expression expr;

  public ZeroExpr(Expression expr) {
    this.expr = expr;
  }
}
