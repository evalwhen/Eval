package com.eval.interpreter.parser;

import com.eval.interpreter.combinator.Parser;
import com.eval.interpreter.combinator.PrintCont;
import org.junit.Test;

public class ScannerTest {

  @Test
  public void scan() {
    Scanner s = new Scanner();

    Parser p = new Sexp();
    System.out.println(s.scan("(let (x 2) (+ x 4))"));
    p.parse(s.scan("(let (x 2) (- x 4))"), new PrintCont());
  }
}