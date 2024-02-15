package ch.authenticit.study;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    var ll = new LinkedList();
    ll.addFirst(20);
    ll.addFirst(10);
    ll.addLast(30);
    ll.addLast(40);
    ll.addLast(50);

    var oddNumberMiddle = ll.getMiddle();
    ll.addLast(60);
    var evenNumberMiddle = ll.getMiddle();

    System.out.println("OddNumberMiddle: " + Arrays.toString(oddNumberMiddle));
    System.out.println("EvenNumberMiddle: " + Arrays.toString(evenNumberMiddle));
  }
}
