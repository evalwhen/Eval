package com.eval.interpreter;

import com.eval.interpreter.combinator.ParseResult;
import com.eval.interpreter.combinator.Parser;
import com.eval.interpreter.combinator.ParserEndCont;
import com.eval.interpreter.combinator.Success;
import com.eval.interpreter.continuation.EndCont;
import com.eval.interpreter.environment.EmptyEnv;
import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.expression.ExprVisitor;
import com.eval.interpreter.expression.Expression;
import com.eval.interpreter.expression.NumValue;
import com.eval.interpreter.parser.Ast.AstToExpr;
import com.eval.interpreter.parser.InvalidSyntaxException;
import com.eval.interpreter.parser.Scanner;
import com.eval.interpreter.parser.Sexp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interpreter {
  static Scanner scanner = new Scanner();
  public static void main(String[] args) {
    while (true) {
      System.out.println("=> ");
      BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

      try {
        String line = reader.readLine();
        if (line.equals("exit")) {
          return;
        } else if (line.equals("")) {
          continue;
        } else {

          Parser p = new Sexp();
          ParseResult pr;
          pr = p.parse(scanner.scan(line), new ParserEndCont());
          AstToExpr ate = new AstToExpr();

          Expression letExpr;
          if (pr instanceof Success) {
            letExpr = ((Success)pr).getResult().get(0).toExpr(ate);
            ExprVisitor ev = new ExprVisitor(new EmptyEnv(), new EndCont());
            NumValue val = (NumValue)letExpr.Eval(ev);
            System.out.println(val.getValue());
          } else {
            System.out.println("Parse failure!");
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      } catch (VarNameNotFoundException e) {
        e.printStackTrace();
      } catch (InvalidSyntaxException e) {
        e.printStackTrace();
      }
    }

  }
}
