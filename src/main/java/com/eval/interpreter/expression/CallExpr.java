package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

class CallExpr extends Expression {
  private Expression procedure;
  private Expression argument;

  public CallExpr(Expression procedure, Expression argument) {
    this.procedure = procedure;
    this.argument = argument;
  }

  public ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }

  public Expression getProcedure() {
    return procedure;
  }

  public Expression getArgument() {
    return argument;
  }
}
