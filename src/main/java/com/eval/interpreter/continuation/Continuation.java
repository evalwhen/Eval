package com.eval.interpreter.continuation;

import com.eval.interpreter.value.ExprValue;
import com.eval.interpreter.environment.VarNameNotFoundException;

public abstract class Continuation {
  public abstract ExprValue apply(ContVistorI ask, ExprValue val) throws VarNameNotFoundException;
}

