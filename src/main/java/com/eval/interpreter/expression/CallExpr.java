package com.eval.interpreter.expression;

import com.eval.interpreter.value.ExprValue;

class CallExpr extends Expression {
  private Expression procedure;
  private Expression argument;

  public CallExpr(Expression procedure, Expression argument) {
    this.procedure = procedure;
    this.argument = argument;
  }

  public ExprValue Eval(ExprVisitorI ask) {
    return ask.visit(this);
  }
}
