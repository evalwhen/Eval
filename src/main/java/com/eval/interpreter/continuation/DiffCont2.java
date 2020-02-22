package com.eval.interpreter.continuation;

import com.eval.interpreter.environment.Environment;
import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public class DiffCont2 extends Continuation {
  private ExprValue v1;
  private Environment currentEnv;
  private Continuation savedCont;

  public DiffCont2(ExprValue v1, Environment currentEnv, Continuation savedCont) {
    this.v1 = v1;
    this.currentEnv = currentEnv;
    this.savedCont = savedCont;
  }

  public ExprValue getV1() {
    return v1;
  }

  public Environment getCurrentEnv() {
    return currentEnv;
  }

  public Continuation getSavedCont() {
    return savedCont;
  }

  public ExprValue apply(ContVistorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }
}
