package com.eval.value;

class ProcValue extends ExprValue {
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
