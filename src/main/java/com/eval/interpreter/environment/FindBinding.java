package com.eval.interpreter.environment;

import com.eval.interpreter.value.ExprValue;
import com.eval.interpreter.value.ProcValue;
import com.eval.interpreter.value.Procedure;

public class FindBinding implements EnvVistorI<ExprValue> {
  public ExprValue visit (EmptyEnv env, String var) throws VarNameNotFoundException {
    throw new VarNameNotFoundException("undefined variable " + var + "!\n");
  }

  public ExprValue visit(ExtendEnv env, String var) throws VarNameNotFoundException {
    if (var.equals(env.varName)) {
      return env.value;
    } else {
      return env.savedEnv.findBinding(this, var);
    }
  }

  public ExprValue visit(ExtendEnvRec env, String var) throws VarNameNotFoundException {
    if (var.equals(env.getProcName())) {
      return new ProcValue(new Procedure(env.getVarName(), env.getBody(), env));
    } else {
      return env.getSavedEnv().findBinding(this, var);
    }
  }
}
