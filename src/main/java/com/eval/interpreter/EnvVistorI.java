package com.eval.interpreter;

interface EnvironmentVisitorI<T> {
  T visit (EmptyEnv env, String var) throws VarNameNotFoundException;
  T visit(ExtendEnv env, String var) throws VarNameNotFoundException;
  T visit(ExtendEnvRec env, String var) throws VarNameNotFoundException;
}
