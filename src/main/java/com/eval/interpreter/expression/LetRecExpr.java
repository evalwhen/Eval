package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

class LetRecExpr extends Expression {
  private String procName;
  private String varName;
  private Expression procBody;
  private Expression letBody;

  public LetRecExpr(String procName, String varName, Expression procBody, Expression letBody) {
    this.procName = procName;
    this.varName = varName;
    this.procBody = procBody;
    this.letBody = letBody;
  }

  public ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }

  public String getProcName() {
    return procName;
  }

  public String getVarName() {
    return varName;
  }

  public Expression getProcBody() {
    return procBody;
  }

  public Expression getLetBody() {
    return letBody;
  }
}
