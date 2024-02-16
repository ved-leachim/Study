package ch.authenticit.study;

import ch.authenticit.study.stack.ArrayStack;

public class Main {
  public static void main(String[] args) {
    var arrayStack = new ArrayStack(2);
    arrayStack.push(10);
    arrayStack.push(20);
    System.out.println("Should be 20: " + arrayStack.peek());
    arrayStack.push(30);
    arrayStack.push(40);
    arrayStack.push(50);
    System.out.println("Should be 50: " + arrayStack.peek());
    arrayStack.pop();
    System.out.println("Pop should be 40: " + arrayStack.pop());
    System.out.println("Should be 30: " + arrayStack.peek());
    arrayStack.pop();
    arrayStack.pop();
    arrayStack.pop();
    arrayStack.pop();
  }
}
