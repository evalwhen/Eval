package com.eval.interpreter;

class VarExpr extends Expression {
  String varName;

  public VarExpr(String varName) {
    this.varName = varName;
  }

  ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }
}
