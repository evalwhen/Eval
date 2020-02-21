package com.eval.interpreter.environment;

import com.eval.interpreter.value.ExprValue;
import com.eval.interpreter.expression.Expression;

class ExtendEnvRec extends Environment {
  private String procName;
  private String varName;
  private Expression body;
  private Environment savedEnv;

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

  String getProcName() {
    return procName;
  }

  String getVarName() {
    return varName;
  }

  Expression getBody() {
    return body;
  }

  Environment getSavedEnv() {
    return savedEnv;
  }
}
