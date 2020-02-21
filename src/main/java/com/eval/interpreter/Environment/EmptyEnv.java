package com.eval.interpreter.Environment;

import com.eval.interpreter.ExprValue;

public class EmptyEnv extends Environment {
  Environment extendEnv(String varName, ExprValue value) {
    return null;
  }

  public ExprValue findBinding(EnvVistorI ask, String var) throws VarNameNotFoundException {
    return (ExprValue) ask.visit(this, var);
  }
}
