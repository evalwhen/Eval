package com.eval.interpreter;

import com.eval.interpreter.Environment.VarNameNotFoundException;

class ConstExpr extends Expression {
  private Integer n;

  ConstExpr(Integer n) {
    this.n = n;
  }

  Integer getN() {
    return n;
  }

  public void setN(Integer n) {
    this.n = n;
  }

  ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }
}
