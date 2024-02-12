package ch.authenticit.study;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    var ll = new LinkedList();
    ll.addFirst(20);
    ll.addFirst(10);
    ll.addLast(30);
    ll.reverse();
    var array = ll.toArray();
    System.out.println(Arrays.toString(array));
    ll.addFirst(35);
    ll.addLast(5);
    array = ll.toArray();
    System.out.println(Arrays.toString(array));
    ll.reverse();
    array = ll.toArray();
    System.out.println(Arrays.toString(array));
  }
}
