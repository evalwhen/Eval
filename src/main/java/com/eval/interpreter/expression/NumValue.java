package com.eval.interpreter.expression;

import com.eval.interpreter.value.BoolValue;
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

  public NumValue diff(NumValue that) {
    return new NumValue(this.value - that.value);
  }

  public BoolValue isZero() {
    if (value == 0) {
      return new BoolValue(new Boolean(true));
    } else {
      return new BoolValue(new Boolean(false));
    }
  }
  public Integer getValue() {
    return value;
  }
}
