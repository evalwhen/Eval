package com.eval.interpreter.continuation;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public abstract class Continuation {
  public abstract ExprValue apply(ContVistorI ask) throws VarNameNotFoundException;
}

