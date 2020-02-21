package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public class ConstExpr extends Expression {
  private Integer n;

  public ConstExpr(Integer n) {
    this.n = n;
  }

  Integer getN() {
    return n;
  }

  public void setN(Integer n) {
    this.n = n;
  }

  public ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }
}
