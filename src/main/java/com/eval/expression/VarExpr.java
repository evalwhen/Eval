package com.eval.expression;

class VarExpr extends Expression {
  private String varName;

  public VarExpr(String varName) {
    this.varName = varName;
  }
}
