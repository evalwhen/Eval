package com.eval.interpreter.continuation;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.value.ExprValue;

public class OperandCont extends Continuation {
  private ExprValue proc;
  private Continuation cont;

  public OperandCont(ExprValue proc, Continuation cont) {
    this.proc = proc;
    this.cont = cont;
  }

  public ExprValue apply(ContVistorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }

  public ExprValue getProc() {
    return proc;
  }

  public Continuation getCont() {
    return cont;
  }
}
