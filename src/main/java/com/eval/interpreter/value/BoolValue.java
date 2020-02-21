package com.eval.interpreter.value;

public class BoolValue extends ExprValue {
  private Boolean val;

  public BoolValue(Boolean val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return "BoolValue{" +
      "valExpr=" + val +
      '}';
  }
}
