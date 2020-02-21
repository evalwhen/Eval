package com.eval.expression;

class DiffExpr extends Expression {
  private Expression exp1;
  private Expression exp2;

  public DiffExpr(Expression exp1) {
    this.exp1 = exp1;
  }

  public Expression getExp1() {
    return exp1;
  }

  public Expression getExp2() {
    return exp2;
  }
}

