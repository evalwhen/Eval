package com.eval.interpreter;

import com.eval.interpreter.Environment.VarNameNotFoundException;

public abstract class Expression {
  abstract ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException;
}
