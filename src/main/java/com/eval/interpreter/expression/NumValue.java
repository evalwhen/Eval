package com.eval.interpreter.expression;

import com.eval.interpreter.value.ExprValue;

public class NumValue extends ExprValue {
  private Integer value;

  NumValue(Integer value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "NumValue{" +
      "value=" + value +
      '}';
  }

  public Integer getValue() {
    return value;
  }
}
