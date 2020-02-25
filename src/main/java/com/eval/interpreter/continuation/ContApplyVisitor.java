package com.eval.interpreter.continuation;

import com.eval.interpreter.environment.ExtendEnv;
import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.expression.ExprVisitor;
import com.eval.interpreter.expression.NumValue;
import com.eval.interpreter.value.BoolValue;
import com.eval.interpreter.value.ExprValue;
import com.eval.interpreter.value.ProcValue;
import com.eval.interpreter.value.Procedure;

public class ContApplyVisitor implements ContVistorI {
  private ExprValue val;

  public ContApplyVisitor(ExprValue numValue) {
    this.val = numValue;
  }

  public ExprValue visit(EndCont cont) {
    return val;
  }

  public ExprValue visit(LetCont cont) throws VarNameNotFoundException {
    // 新建 ExprVistor, 扩展环境（局部变量引入）, continuation 变短
    ExprVisitor v = new ExprVisitor(
      new ExtendEnv(cont.getVarName(), val, cont.getEnv()),
      cont.getSavedCont()
    );
    return cont.getLetBody().Eval(v);
  }

  public ExprValue visit(ZeroCont cont) throws VarNameNotFoundException {
    NumValue testValue = (NumValue) val;
    this.val = testValue.isZero();
    return cont.getSavedCont().apply(this);
  }

  public ExprValue visit(DiffCont1 diffCont1) throws VarNameNotFoundException {
   ExprVisitor v = new ExprVisitor(
      diffCont1.getCurrentEnv(),
      new DiffCont2(val, diffCont1.getCurrentEnv(), diffCont1.getSavedCont())
    );
    return diffCont1.getExp2().Eval(v);
  }

  public ExprValue visit(DiffCont2 diffCont2) throws VarNameNotFoundException {
    NumValue v1 = (NumValue)diffCont2.getV1();
    NumValue v2 = (NumValue) val;
    this.val = v1.diff(v2);
    return diffCont2.getSavedCont().apply(this);
  }

  public ExprValue visit(IfCont ifCont) throws VarNameNotFoundException {
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

  public ExprValue visit(OperatorCont ratorCont) throws VarNameNotFoundException {
    ProcValue proc = (ProcValue) this.val;

    ExprVisitor v = new ExprVisitor(
      ratorCont.getCurrentEnv(),
      new OperandCont(proc, ratorCont.getSavedCont())
    );
    return ratorCont.getArgument().Eval(v);
  }

  public ExprValue visit(OperandCont randCont) throws VarNameNotFoundException {
    Procedure proc =
      ((ProcValue) randCont.getProc()).getProc();
    ExprVisitor v = new ExprVisitor(
      new ExtendEnv(proc.getVarName(), this.val, proc.getEnv()),
      randCont.getCont()
    );
    System.out.println(this.val);
    return proc.getBody().Eval(v);
  }

  public ExprValue getVal() {
    return val;
  }
}
