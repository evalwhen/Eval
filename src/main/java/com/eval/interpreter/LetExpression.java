package com.eval.interpreter;

class LetExpr extends Expression {
  String varName;
  Expression valExpr;
  Expression body;

  ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }
}
