package com.eval.interpreter;

class ExtendEnvRec extends Environment {
  String procName;
  String varName;
  Expression body;
  Environment savedEnv;

  public ExtendEnvRec(String procName, String varName, Expression body, Environment savedEnv) {
    this.procName = procName;
    this.varName = varName;
    this.body = body;
    this.savedEnv = savedEnv;
  }

  Environment extendEnv(String varName, ExprValue value) {
    return null;
  }

  ExprValue findBinding(EnvironmentVisitorI ask, String var) throws VarNameNotFoundException {
    return (ExprValue)ask.visit(this, var);
  }
}
