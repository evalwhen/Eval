package com.eval.expression;

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
}
