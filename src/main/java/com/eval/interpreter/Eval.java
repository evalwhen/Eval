package com.eval.interpreter;

import com.eval.interpreter.combinator.ParseResult;
import com.eval.interpreter.combinator.Parser;
import com.eval.interpreter.combinator.Success;
import com.eval.interpreter.continuation.EndCont;
import com.eval.interpreter.environment.EmptyEnv;
import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.expression.ExprVisitor;
import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.combinator.ParserEndCont;
import com.eval.interpreter.expression.NumValue;
import com.eval.interpreter.parser.Ast.AstToExpr;
import com.eval.interpreter.parser.InvalidSyntaxException;
import com.eval.interpreter.parser.Sexp;
import com.eval.interpreter.parser.Token;
import com.eval.interpreter.value.ExprValue;

import java.util.List;

class Eval {
  static ExprValue eval(List<Token> toks) throws InvalidSyntaxException, VarNameNotFoundException {
    Parser p = new Sexp();
    ParseResult pr;
    pr = p.parse(toks, new ParserEndCont());
    AstToExpr ate = new AstToExpr();

    Expression letExpr;
    if (pr instanceof Success) {
      letExpr = ((Success)pr).getResult().get(0).toExpr(ate);
      ExprVisitor ev = new ExprVisitor(new EmptyEnv(), new EndCont());
      NumValue val = (NumValue)letExpr.Eval(ev);
      return val;
    } else {
      throw new InvalidSyntaxException("无效的表达式！");
    }
  }
}
