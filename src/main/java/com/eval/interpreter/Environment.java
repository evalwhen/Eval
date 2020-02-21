package com.eval.interpreter;

abstract class Environment {
  abstract Environment extendEnv(String varName, ExprValue value);
  abstract ExprValue findBinding(EnvironmentVisitorI ask, String var) throws VarNameNotFoundException;
}
