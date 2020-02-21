package com.eval.interpreter.continuation;

import com.eval.interpreter.value.ExprValue;
import com.eval.interpreter.expression.ExprVisitor;
import com.eval.interpreter.environment.ExtendEnv;
import com.eval.interpreter.environment.VarNameNotFoundException;

public class ContApplyVistor implements ContVistorI {
  public ExprValue visit(EndCont cont, ExprValue val) {
    return val;
  }

  public ExprValue visit(LetCont cont, ExprValue val) throws VarNameNotFoundException {
    // 新建 ExprVistor, 扩展环境（局部变量引入）, continuation 变短
    ExprVisitor v = new ExprVisitor(
      new ExtendEnv(cont.getVarName(), val, cont.getEnv()),
      cont.getSavedCont()
    );
    return cont.getLetBody().Eval(v);
  }
}
