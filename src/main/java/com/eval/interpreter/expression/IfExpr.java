package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

class IfExpr extends Expression {
  private Expression cond; // 条件必表达式
  private Expression then;
  private Expression els;

  public IfExpr(Expression cond, Expression then, Expression els) {
    this.cond = cond;
    this.then = then;
    this.els = els;
  }

  public ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }

  public Expression getCond() {
    return cond;
  }

  public Expression getThen() {
    return then;
  }

  public Expression getEls() {
    return els;
  }
}
