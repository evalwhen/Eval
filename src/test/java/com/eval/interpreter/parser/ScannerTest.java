package com.eval.interpreter.parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScannerTest {

  @Test
  public void scan() {
    Scanner s = new Scanner();

    System.out.println(s.scan("(let (x 2) (+ x 4))"));
  }
}