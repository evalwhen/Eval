package com.eval.interpreter.combinator;

import com.eval.interpreter.parser.Scanner;
import com.eval.interpreter.parser.Sexp;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {
  static Scanner scanner = new Scanner();

  @Test
  public void testOrParser() {
    List<Parser> ps = new ArrayList<Parser>();
    ps.add(new StringParser("("));
    ps.add(new StringParser(")"));

    Parser p = new OrParser(ps);

    p.parse(scanner.scan("(+ 1 2)" ), new PrintCont());
    p.parse(scanner.scan(")"), new PrintCont());
  }

  @Test
  public void testAndParser() {
    List<Parser> ps = new ArrayList<Parser>();
    List<ParseResult> rest = new ArrayList<ParseResult>();

    ps.add(new NotParser(new StringParser("(")));
    ps.add(new NotParser(new StringParser(")")));

    Parser p = new AndParser(ps, rest);

    p.parse(scanner.scan("+ 1 2"), new PrintCont());
    p.parse(scanner.scan("(+ 1 2)"), new PrintCont());
  }

  @Test
  public void testStarParser() {
    List<Ast> list = new ArrayList<Ast>();
    Parser p = new StarParser(new StringParser("aaa"), list);

    p.parse(scanner.scan("aaa aaa a b"), new PrintCont());
  }

  @Test
  public void testTagParser() {
    Parser p = new TagParser(Ast.NodeType.parens, new StringParser("("));

    p.parse(scanner.scan("(00"), new PrintCont());
  }

  @Test
  public void testSexpParser() {
    Parser p = new Sexp();
    p.parse(scanner.scan("(+ 12 23 ( + 43 4444))"), new PrintCont());
  }
}