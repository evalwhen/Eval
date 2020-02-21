package com.eval.interpreter;

abstract class Continuation {
  abstract ExprValue apply(ContVistorI ask, ExprValue val);
}

class EndCont extends Continuation {
  ExprValue apply(ContVistorI ask, ExprValue val) {
    return ask.visit(this, val);
  }
}

class LetCont extends Continuation {
  String varName;
  Expression letBody;
  Continuation savedCont;

  public LetCont(String varName, Expression letBody, Continuation savedCont) {
    this.varName = varName;
    this.letBody = letBody;
    this.savedCont = savedCont;
  }

  ExprValue apply(ContVistorI ask, ExprValue val) {
    return ask.visit(this, val);
  }
}
