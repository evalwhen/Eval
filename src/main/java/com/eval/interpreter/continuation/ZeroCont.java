package com.eval.interpreter.continuation;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public class ZeroCont extends Continuation {
  private Continuation savedCont;

  public ZeroCont(Continuation savedCont) {
    this.savedCont = savedCont;
  }

  public ExprValue apply(ContVistorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }

  public Continuation getSavedCont() {
    return savedCont;
  }
}
