package com.eval.interpreter.continuation;

import com.eval.interpreter.value.ExprValue;

public class EndCont extends Continuation {
  public ExprValue apply(ContVistorI ask) {
    return ask.visit(this);
  }
}
