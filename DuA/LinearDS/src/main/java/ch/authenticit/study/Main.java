package ch.authenticit.study;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    var ll = new LinkedList();
    ll.addFirst(10);
    ll.addLast(20);
    ll.addLast(30);
    ll.addLast(40);
    ll.addLast(50);
    ll.addLast(60);
    System.out.println("has Loop should be false: " + ll.hasLoop());
    ll.addLoop();
    System.out.println("has Loop should be true: " + ll.hasLoop());
  }
}
