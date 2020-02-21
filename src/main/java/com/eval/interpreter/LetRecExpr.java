package com.eval.interpreter;

class LetRecExpr extends Expression {
  private String procName;
  private String varName;
  private Expression ProcBody;
  private Expression letBody;

  public LetRecExpr(String procName, String varName, Expression procBody, Expression letBody) {
    this.procName = procName;
    this.varName = varName;
    ProcBody = procBody;
    this.letBody = letBody;
  }

  ExprValue Eval(ExprVisitorI ask) {
    return ask.visit(this);
  }
}
