package ch.authenticit.study;

import ch.authenticit.study.stack.ExpressionChecker;

public class Main {
  public static void main(String[] args) {
    System.out.println(ExpressionChecker.isBalanced("(1() )[[]]()+( 2)<> -- [abc]"));
  }
}
