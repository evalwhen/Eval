package com.eval.interpreter.continuation;

import com.eval.interpreter.value.ExprValue;

public class EndCont extends Continuation {
  public ExprValue apply(ContVistorI ask, ExprValue val) {
    return ask.visit(this, val);
  }
}
