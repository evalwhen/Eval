package com.eval.interpreter.parser;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

  public List<Token> scan(String str) {
    ArrayList<Token> result = new ArrayList<Token>();
    int start = 0;
    while (true){
      ScannerResult sr = helper(str, start);
      if (sr instanceof EOF) {
        return result;
      } else {
        result.add(sr.getTok());
        start = sr.getNext();
      }
    }
  }

  private ScannerResult helper(String str, int start) {
    if (str.length() == start) {
      return new EOF(new Token(start, start, ""), start);
    } else if (str.charAt(start) == ' ') {
      return helper(str, start+1);
    } else if (isDelim(str, start)) {
      Token t = new Token(start, start + 1, String.valueOf(str.charAt(start)));
      return new ScannerResult(t, start+1);
    } else {
      String s = "";
      for (int i = start; i < str.length() && str.charAt(i) != ' ' && !isDelim(str, i); i++) {
        s += String.valueOf(str.charAt(i));
      }
      Token t = new Token(start, start + s.length(), s);
      return new ScannerResult(t, start + s.length());
    }
  }

  private boolean isDelim(String str, int start) {
    return str.charAt(start) == '(' || str.charAt(start) == ')';
  }
}
