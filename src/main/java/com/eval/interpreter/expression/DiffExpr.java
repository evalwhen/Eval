package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public class DiffExpr extends Expression {
  private Expression exp1;
  private Expression exp2;

  public DiffExpr(Expression exp1, Expression exp2) {
    this.exp1 = exp1;
    this.exp2 = exp2;
  }

  public Expression getExp1() {
    return exp1;
  }

  public Expression getExp2() {
    return exp2;
  }

  public ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }
}

