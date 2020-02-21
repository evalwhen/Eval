package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public class LetExp extends Expression {
  String varName;
  Expression valExpr;
  Expression body;

  public LetExp(String varName, Expression valExpr, Expression body) {
    this.varName = varName;
    this.valExpr = valExpr;
    this.body = body;
  }

  public ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }
}
