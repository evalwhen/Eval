package com.eval.value;

class BoolValue extends ExprValue {
  private Boolean val;

  public BoolValue(Boolean val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return "BoolValue{" +
      "val=" + val +
      '}';
  }
}
