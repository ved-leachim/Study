package ch.authenticit.study;

public class Main {
  public static void main(String[] args) {
    var ll = new LinkedList();
    System.out.println(ll.size());
    ll.addFirst(20);
    ll.addFirst(10);
    ll.addLast(30);
    System.out.println(ll.size());
    ll.print();
    System.out.println(ll.indexOf(15));
    System.out.println(ll.indexOf(20));
    System.out.println(ll.contains(20));
    ll.deleteFirst();
    System.out.println(ll.size());
    ll.deleteLast();
    ll.print();
    ll.deleteLast();
    ll.print();
  }
}
