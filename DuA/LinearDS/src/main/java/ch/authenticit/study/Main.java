package ch.authenticit.study;

public class Main {
  public static void main(String[] args) {
    var ll = new LinkedList();
    ll.addFirst(20);
    ll.addFirst(10);
    ll.addLast(30);
    ll.print();
    System.out.println(ll.indexOf(15));
    System.out.println(ll.indexOf(20));
    System.out.println(ll.contains(20));
    ll.deleteFirst();
    ll.deleteLast();
    ll.print();
  }
}
