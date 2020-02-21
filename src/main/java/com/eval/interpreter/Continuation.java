package com.eval.interpreter;

import com.eval.interpreter.Environment.Environment;
import com.eval.interpreter.Environment.VarNameNotFoundException;

abstract class Continuation {
  abstract ExprValue apply(ContVistorI ask, ExprValue val) throws VarNameNotFoundException;
}

class EndCont extends Continuation {
  Environment env;
  ExprValue apply(ContVistorI ask, ExprValue val) {
    return ask.visit(this, val);
  }
}

class LetCont extends Continuation {
  String varName;
  Expression letBody;
  Environment env;
  Continuation savedCont;


  LetCont(String varName, Expression letBody, Environment env, Continuation cont) {
    this.varName = varName;
    this.letBody = letBody;
    this.env = env;
    this.savedCont = cont;
  }

  ExprValue apply(ContVistorI ask, ExprValue val) throws VarNameNotFoundException {
    return ask.visit(this, val);
  }
}
