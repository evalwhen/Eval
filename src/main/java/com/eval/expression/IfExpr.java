package com.eval.expression;

class IfExpr extends Expression {
  private Expression cond; // 条件必表达式
  private Expression then;
  private Expression els;

  public IfExpr(Expression cond, Expression then, Expression els) {
    this.cond = cond;
    this.then = then;
    this.els = els;
  }
}
