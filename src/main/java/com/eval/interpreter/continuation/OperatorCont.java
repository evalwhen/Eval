package com.eval.interpreter.continuation;

import com.eval.interpreter.environment.Environment;
import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.value.ExprValue;

public class OperatorCont extends Continuation {
  private Expression argument;
  private Environment currentEnv;
  private Continuation savedCont;

  public OperatorCont(Expression argument, Environment currentEnv, Continuation savedCont) {
    this.argument = argument;
    this.currentEnv = currentEnv;
    this.savedCont = savedCont;
  }

  public ExprValue apply(ContVistorI ask) throws VarNameNotFoundException {
    return ask.visit(this);
  }

  public Expression getArgument() {
    return argument;
  }

  public Environment getCurrentEnv() {
    return currentEnv;
  }

  public Continuation getSavedCont() {
    return savedCont;
  }
}
