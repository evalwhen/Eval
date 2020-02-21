package com.eval.interpreter;

class FindBinding implements EnvironmentVisitorI<ExprValue> {
  public ExprValue visit (EmptyEnv env, String var) throws VarNameNotFoundException {
    throw new VarNameNotFoundException("undefined variable" + var + "!\n");
  }

  public ExprValue visit(ExtendEnv env, String var) throws VarNameNotFoundException {
    if (var.equals(env.varName)) {
      return env.value;
    } else {
      return env.savedEnv.findBinding(this, var);
    }
  }

  public ExprValue visit(ExtendEnvRec env, String var) throws VarNameNotFoundException {
    if (var.equals(env.varName)) {
      return new ProcValue(new Procedure(env.varName, env.body, env));
    } else {
      return env.savedEnv.findBinding(this, var);
    }
  }
}
