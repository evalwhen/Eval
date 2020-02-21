package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public class VarExpr extends Expression {
  String varName;

  public VarExpr(String varName) {
    this.varName = varName;
  }

  public ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }
}
