package com.eval.interpreter.environment;

public interface EnvVistorI<T> {
  T visit (EmptyEnv env, String var) throws VarNameNotFoundException;
  T visit(ExtendEnv env, String var) throws VarNameNotFoundException;
  T visit(ExtendEnvRec env, String var) throws VarNameNotFoundException;
}
