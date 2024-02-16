package ch.authenticit.study;

import java.util.NoSuchElementException;

public class LinkedList {
  private Node first;
  private Node last;
  private int size = 0;

  public void addFirst(int value) {
    var newNode = new Node(value);

    if (isEmpty())
      first = last = newNode;
    else {
      newNode.next = first;
      first = newNode;
    }

    size++;
  }

  public void addLast(int value) {
    var newNode = new Node(value);

    if (isEmpty())
      first = last = newNode;
    else {
      last.next = newNode;
      last = newNode;
    }

    size++;
  }

  public void deleteFirst() {
    if (isEmpty())
      throw new IllegalStateException("Cannot delete a Node from an empty Linked List");

    if (first == last)
      first = last = null;
    else {
      first = first.next;
    }

    size--;
  }

  public void deleteLast() {
    if (isEmpty())
      throw new NoSuchElementException("Cannot delete a Node from an empty Linked List");

    if (first == last)
      first = last = null;
    else {
      var current = first;
      while (current.next != last) {
        current = current.next;
      }
      current.next = null;
      last = current;
    }
  }

  public boolean contains(int value) {
    for (Node current = first; current != null; current = current.next) {
      if (value == current.value)
        return true;
    }
    return false;
  }

  public int indexOf(int value) {
    int index = 0;
    for (Node current = first; current != null; current = current.next) {
      if (value == current.value) {
        return index;
      }
      index++;
    }
    return -1;
  }

  public int size() {
    return size;
  }

  public void reverse() {
    if (isEmpty()) return;

    last = first;
    var current = first.next;
    first.next = null;
    while (current != null) {
      var nextNode = current.next;
      current.next = first;
      first = current;
      current = nextNode;
    }
  }

  public Node getKthFromTheEnd(int k) {
    if (k <= 0)
      throw new IllegalArgumentException("The Kth Node not cannot be 0 or a negative number.");

    if (k > size)
      throw new IllegalStateException("Cannot get Kth Node bigger than count of Nodes in Linked List.");

    int distance = k - 1;

    var stopper = first;
    var kthNode = first;
    int i = 0;

    while (stopper != last) {
      stopper = stopper.next;

      if (i >= distance)
        kthNode = kthNode.next;

      i++;
    }

    return kthNode;
  }

  public int[] getMiddle() {
    if (isEmpty())
      return null;

    int m = (int) Math.round(size / 2.0);
    var middleNode = first;

    for(int i = 1; i != m; i++) {
      middleNode = middleNode.next;
    }

    if (size % 2 == 0)
      return new int[] {middleNode.value, middleNode.next.value};

    return new int[] {middleNode.value};
  }

  public boolean hasLoop() {
    var slow = first;
    var fast = first;

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      fast = fast.next;

      if (fast == slow)
        return true;
    }
    return false;
  }

  // This method only exists for testing the hasLoop() method
  public void addLoop() {
    last.next = first;
  }

  public int[] toArray() {
    int[] array = new int[size];
    var current = first;
    var index = 0;
    while (current != null) {
      array[index++] = current.value;
      current = current.next;
    }

    return array;
  }

  public void print() {
    for (Node current = first; current != null; current = current.next)
      System.out.println(current.value);
  }

  private boolean isEmpty() {
    return first == null;
  }

  private static class Node {
    private final int value;
    private Node next;

    @Override
    public String toString() {
      return Integer.toString(value);
    }

    public Node(int value) {
      this.value = value;
    }
  }
}
