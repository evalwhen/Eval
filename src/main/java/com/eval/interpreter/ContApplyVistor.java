package com.eval.interpreter;

class ContApplyVistor implements ContVistorI {
  public ExprValue visit(EndCont cont, ExprValue val) {
    return cont.apply(this, val);
  }

  public ExprValue visit(LetCont cont, ExprValue val) throws VarNameNotFoundException {
    ((Eval)cont.eval).extendEnvironment(cont.varName, val);
    return cont.letBody.Eval(cont.eval);
  }
}
