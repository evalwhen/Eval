package com.eval.interpreter;

class ProcedureExpr extends Expression  {
  private String varName;
  private Expression body;

  public ProcedureExpr(String varName, Expression body) {
    this.varName = varName;
    this.body = body;
  }

  ExprValue Eval(ExprVisitorI ask) {
    return ask.visit(this);
  }
}
