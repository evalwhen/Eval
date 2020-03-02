package com.eval.interpreter;

import com.eval.interpreter.environment.VarNameNotFoundException;
import com.eval.interpreter.expression.NumValue;
import com.eval.interpreter.parser.InvalidSyntaxException;
import com.eval.interpreter.parser.Scanner;

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

          NumValue val = (NumValue) Eval.eval(scanner.scan(line));
          System.out.println(val.getValue());
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
