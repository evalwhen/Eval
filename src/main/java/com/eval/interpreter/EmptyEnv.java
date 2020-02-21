package com.eval.interpreter;

class EmptyEnv extends Environment {
  Environment extendEnv(String varName, ExprValue value) {
    return null;
  }

  ExprValue findBinding(EnvironmentVisitorI ask, String var) throws VarNameNotFoundException {
    return (ExprValue) ask.visit(this, var);
  }
}
