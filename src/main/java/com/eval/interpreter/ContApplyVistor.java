package com.eval.interpreter;

import com.eval.interpreter.Environment.ExtendEnv;
import com.eval.interpreter.Environment.VarNameNotFoundException;

class ContApplyVistor implements ContVistorI {
  public ExprValue visit(EndCont cont, ExprValue val) {
    return val;
  }

  public ExprValue visit(LetCont cont, ExprValue val) throws VarNameNotFoundException {
    // 新建 ExprVistor, 扩展环境（局部变量引入）, continuation 变短
    ExprVisitor v = new ExprVisitor(
      new ExtendEnv(cont.varName, val, cont.env),
      cont.savedCont
    );
    return cont.letBody.Eval(v);
  }
}
