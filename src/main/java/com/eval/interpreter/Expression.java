package com.eval.interpreter;

public abstract class Expression {
  abstract ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException;
}
