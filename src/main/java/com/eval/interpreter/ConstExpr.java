package com.eval.interpreter;

class ConstExpr extends Expression {
  private Integer n;

  public ConstExpr(Integer n) {
    this.n = n;
  }

  public Integer getN() {
    return n;
  }

  public void setN(Integer n) {
    this.n = n;
  }

  ExprValue Eval(ExprVisitorI ask) {
    return ask.visit(this);
  }
}
