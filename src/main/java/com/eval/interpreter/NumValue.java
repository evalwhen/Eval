package com.eval.interpreter;

public class NumValue extends ExprValue {
  private Integer value;

  public NumValue(Integer value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "NumValue{" +
      "value=" + value +
      '}';
  }
}
