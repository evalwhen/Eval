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
//  Environment env;
//  Continuation savedCont;
  ExprVisitorI eval;


  public LetCont(String varName, Expression letBody, ExprVisitorI eval) {
    this.varName = varName;
    this.letBody = letBody;
    this.eval = eval;
  }

  ExprValue apply(ContVistorI ask, ExprValue val) {
    return ask.visit(this, val);
  }
}
