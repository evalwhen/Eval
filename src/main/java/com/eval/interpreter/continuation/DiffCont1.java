package com.eval.interpreter.continuation;

import com.eval.interpreter.environment.Environment;
import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.value.ExprValue;

public class DiffCont1 extends Continuation {
  private Expression exp2;
  private Environment currentEnv;
  private Continuation savedCont;

  public DiffCont1(Expression exp2, Environment currentEnv, Continuation cont) {
    this.exp2 = exp2;
    this.currentEnv = currentEnv;
    this.savedCont = cont;
  }

  public ExprValue apply(ContVistorI ask, ExprValue val) throws VarNameNotFoundException {
    return ask.visit(this, val);
  }

  public Expression getExp2() {
    return exp2;
  }

  public Continuation getSavedCont() {
    return savedCont;
  }

  public Environment getCurrentEnv() {
    return currentEnv;
  }
}
