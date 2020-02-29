package com.eval.interpreter.combinator;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Parser> ps = new ArrayList<Parser>();
    ArrayList<Ast> nodes = new ArrayList<Ast>();
    ps.add(new StringParser("("));
    ps.add(new StringParser("("));
    ps.add(new StringParser("("));
    SeqParser p = new SeqParser(ps, nodes);

    p.parse("(((x", new PrintCont());
  }
}
