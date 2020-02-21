package com.eval.interpreter.environment;

import com.eval.interpreter.value.ExprValue;

public class EmptyEnv extends Environment {
  Environment extendEnv(String varName, ExprValue value) {
    return null;
  }

  public ExprValue findBinding(EnvVistorI ask, String var) throws VarNameNotFoundException {
    return (ExprValue) ask.visit(this, var);
  }
}
