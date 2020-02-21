package com.eval.interpreter.expression;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public abstract class Expression {
  public abstract ExprValue Eval(ExprVisitorI ask) throws VarNameNotFoundException;
}
