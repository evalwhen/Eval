package com.eval.interpreter.environment;

import com.eval.interpreter.value.ExprValue;

public abstract class Environment {
  abstract Environment extendEnv(String varName, ExprValue value);
  public abstract ExprValue findBinding(EnvVistorI ask, String var) throws VarNameNotFoundException;
}
