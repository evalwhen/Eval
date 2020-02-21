package com.eval.interpreter;

import com.eval.interpreter.Environment.VarNameNotFoundException;

class VarExpr extends Expression {
  String varName;

  public VarExpr(String varName) {
    this.varName = varName;
  }

  ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }
}
