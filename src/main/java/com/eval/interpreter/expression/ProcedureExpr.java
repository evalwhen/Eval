package com.eval.interpreter.expression;

import com.eval.interpreter.expression.ExprVisitorI;
import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.value.ExprValue;

class ProcedureExpr extends Expression {
  private String varName;
  private Expression body;

  public ProcedureExpr(String varName, Expression body) {
    this.varName = varName;
    this.body = body;
  }

  public ExprValue Eval(ExprVisitorI ask) {
    return ask.visit(this);
  }
}
