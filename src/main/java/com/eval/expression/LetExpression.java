package com.eval.expression;

class LetExpr extends Expression {
  String varName;
  Expression val;
  Expression body;
}
