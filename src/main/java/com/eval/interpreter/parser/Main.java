package com.eval.interpreter.parser;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Parser> ps = new ArrayList<Parser>();
    ps.add(new StringParser("("));
    ps.add(new StringParser("("));
    ps.add(new StringParser("("));
    SeqParser p = new SeqParser(ps, "");

    p.parse("(((x", new PrintCont());
  }
}
