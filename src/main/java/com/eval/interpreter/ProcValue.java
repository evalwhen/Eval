package com.eval.interpreter;

public class ProcValue extends ExprValue {
  private Procedure proc;

  public ProcValue(Procedure proc) {
    this.proc = proc;
  }

  @Override
  public String toString() {
    return "ProcValue{" +
      "proc=" + proc +
      '}';
  }
}
