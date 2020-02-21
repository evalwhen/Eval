package com.eval.interpreter.Environment;

import com.eval.interpreter.ExprValue;
import com.eval.interpreter.Expression;

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

  public ExprValue findBinding(EnvVistorI ask, String var) throws VarNameNotFoundException {
    return (ExprValue)ask.visit(this, var);
  }
}
