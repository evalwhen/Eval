package com.eval.expression;

class CallExpr extends Expression {
  private Expression procedure;
  private Expression argument;

  public CallExpr(Expression procedure, Expression argument) {
    this.procedure = procedure;
    this.argument = argument;
  }
}
