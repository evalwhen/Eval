package com.eval.interpreter.Environment;

import com.eval.interpreter.ExprValue;

public class ExtendEnv extends Environment {
  String varName;
  ExprValue value;
  Environment savedEnv;

  public ExtendEnv(String varName, ExprValue value, Environment savedEnv) {
    this.varName = varName;
    this.value = value;
    this.savedEnv = savedEnv;
  }

  Environment extendEnv(String varName, ExprValue value) {
    return null;
  }

  public ExprValue findBinding(EnvVistorI ask, String var) throws VarNameNotFoundException {
    return (ExprValue)ask.visit(this, var);
  }
}
