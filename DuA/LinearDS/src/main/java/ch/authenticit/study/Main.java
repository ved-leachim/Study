package ch.authenticit.study;

public class Main {
  public static void main(String[] args) {
    Array numbers = new Array(3);
    numbers.insert(10);
    numbers.insert(20);
    numbers.insert(40);
    numbers.insert(50);
    numbers.insertAt(30, 2);
    numbers.insertAt(100, 1);
    numbers.print();
  }
}
