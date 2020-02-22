package com.eval.interpreter.continuation;

import com.eval.interpreter.expression.NumValue;
import com.eval.interpreter.value.BoolValue;
import com.eval.interpreter.value.ExprValue;
import com.eval.interpreter.expression.ExprVisitor;
import com.eval.interpreter.environment.ExtendEnv;
import com.eval.interpreter.environment.VarNameNotFoundException;

public class ContApplyVisitor implements ContVistorI {
  private ExprVisitor val;

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

  public ExprValue visit(ZeroCont cont, ExprValue val) throws VarNameNotFoundException {
    NumValue testValue = (NumValue) val;
    return cont.getSavedCont().apply(this, testValue.isZero());
  }

  public ExprValue visit(DiffCont1 diffCont1, ExprValue val) throws VarNameNotFoundException {
   ExprVisitor v = new ExprVisitor(
      diffCont1.getCurrentEnv(),
      new DiffCont2(val, diffCont1.getCurrentEnv(), diffCont1.getSavedCont())
    );
    return diffCont1.getExp2().Eval(v);
  }

  public ExprValue visit(DiffCont2 diffCont2, ExprValue val) throws VarNameNotFoundException {
    NumValue v1 = (NumValue)diffCont2.getV1();
    NumValue v2 = (NumValue) val;
    NumValue diffResult = v1.diff(v2);

    return diffCont2.getSavedCont().apply(this, diffResult);
  }

  public ExprValue visit(IfCont ifCont, ExprValue val) throws VarNameNotFoundException {
    ExprVisitor v = new ExprVisitor(
      ifCont.getCurrentEnv(),
      ifCont.getCurrentCont()
    );
    BoolValue boolValue = (BoolValue) val;

    if (boolValue.getVal().booleanValue()) {
      return ifCont.getThen().Eval(v);
    } else {
      return ifCont.getEls().Eval(v);
    }
  }

  public ExprVisitor getVal() {
    return val;
  }
}
