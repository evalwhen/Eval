package com.eval.interpreter.value;

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
