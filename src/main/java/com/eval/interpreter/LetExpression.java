package com.eval.interpreter;

class LetExpr extends Expression {
  String varName;
  Expression valExpr;
  Expression body;

  LetExpr(String varName, Expression valExpr, Expression body) {
    this.varName = varName;
    this.valExpr = valExpr;
    this.body = body;
  }

  ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }
}
