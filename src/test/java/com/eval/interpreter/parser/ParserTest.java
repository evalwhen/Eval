package com.eval.interpreter.parser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {

  @Test
  public void testOrParser() {
    List<Parser> ps = new ArrayList<Parser>();
    ps.add(new StringParser("("));
    ps.add(new StringParser(")"));

    Parser p = new OrParser(ps);

    p.parse("(+ 1 2)", new PrintCont());
    p.parse(")", new PrintCont());
  }

  @Test
  public void testAndParser() {
    List<Parser> ps = new ArrayList<Parser>();
    List<ParseResult> rest = new ArrayList<ParseResult>();

    ps.add(new NotParser(new StringParser("(")));
    ps.add(new NotParser(new StringParser(")")));

    Parser p = new AndParser(ps, rest);

    p.parse("+ 1 2", new PrintCont());
    p.parse("(+ 1 2)", new PrintCont());
  }

  @Test
  public void testStarParser() {
    List<Ast> list = new ArrayList<Ast>();
    Parser p = new StarParser(new StringParser("a"), list);

    p.parse("aaab", new PrintCont());
  }

  @Test
  public void testTagParser() {
    Parser p = new TagParser(Ast.NodeType.parens, new StringParser("("));

    p.parse("(00", new PrintCont());
  }

  @Test
  public void testSexpParser() {
    Parser p = new Sexp();
    p.parse("(+12(+34))", new PrintCont());
  }
}