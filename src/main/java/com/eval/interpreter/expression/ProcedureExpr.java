package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

class ProcedureExpr extends Expression {
  private String varName;
  private Expression body;

  public ProcedureExpr(String varName, Expression body) {
    this.varName = varName;
    this.body = body;
  }

  public ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }

  public String getVarName() {
    return varName;
  }

  public Expression getBody() {
    return body;
  }
}
