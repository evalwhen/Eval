package com.eval.interpreter.expression;

import com.eval.interpreter.expression.ExprVisitorI;
import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.value.ExprValue;

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

  public ExprValue Eval(ExprVisitorI ask) {
    return ask.visit(this);
  }
}
