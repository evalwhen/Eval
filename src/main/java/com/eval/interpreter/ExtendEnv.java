package com.eval.interpreter;

class ExtendEnv extends Environment {
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

  ExprValue findBinding(EnvironmentVisitorI ask, String var) throws VarNameNotFoundException {
    return (ExprValue)ask.visit(this, var);
  }
}
