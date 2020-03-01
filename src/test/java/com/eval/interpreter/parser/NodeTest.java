package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.ParseResult;
import com.eval.interpreter.combinator.Parser;
import com.eval.interpreter.combinator.PrintCont;
import com.eval.interpreter.combinator.Success;
import com.eval.interpreter.continuation.EndCont;
import com.eval.interpreter.environment.EmptyEnv;
import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.expression.ExprVisitor;
import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.expression.NumValue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeTest {

  @Test
  public void toExpr() throws InvalidSyntaxException, VarNameNotFoundException {
    Scanner s = new Scanner();

    Parser p = new Sexp();
    ParseResult pr;
    pr = p.parse(s.scan("(let (x 10) (- x 2))"), new PrintCont());
    AstToExpr ate = new AstToExpr();

    Expression letExpr;
    if (pr instanceof Success) {
      letExpr = ((Success)pr).getResult().get(0).toExpr(ate);
      System.out.println(letExpr);
      ExprVisitor ev2 = new ExprVisitor(new EmptyEnv(), new EndCont());
      NumValue val2 = (NumValue)letExpr.Eval(ev2);
      assertEquals(8,val2.getValue().intValue());
    } else {
      assert(false);
    }
  }
}