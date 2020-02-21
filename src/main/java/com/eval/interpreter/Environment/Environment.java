package com.eval.interpreter.Environment;

import com.eval.interpreter.ExprValue;

public abstract class Environment {
  abstract Environment extendEnv(String varName, ExprValue value);
  public abstract ExprValue findBinding(EnvVistorI ask, String var) throws VarNameNotFoundException;
}
