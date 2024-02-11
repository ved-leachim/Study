package ch.authenticit.study;

public class LinkedList {
  private Node first;
  private Node last;

  public void addFirst(int value) {
    var newNode = new Node(value);

    if (isEmpty()) {
      first = newNode;
      last = newNode;
      return;
    }

    newNode.next = first;
    first = newNode;
  }

  public void addLast(int value) {
    var newNode = new Node(value);

    if (isEmpty()) {
      first = newNode;
      last = newNode;
      return;
    }

    last.next = newNode;
    last = newNode;
  }

  public void deleteFirst() {
    if (isEmpty())
      throw new IllegalStateException("Cannot delete a Node from an empty Linked List");

    if (first.equals(last)) {
      first = null;
      last = null;
      return;
    }

    first = first.next;
  }

  public void deleteLast() {
    if (isEmpty())
      throw new IllegalStateException("Cannot delete a Node from an empty Linked List");

    if (first.equals(last)) {
      first = null;
      last = null;
      return;
    }

    for (Node current = first; current != null; current = current.next) {
      if (current.next.equals(last)) {
        current.next = null;
        last = current;
        return;
      }
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

  public void print() {
    for (Node current = first; current != null; current = current.next)
      System.out.println(current.value);
  }

  private boolean isEmpty() {
    return first == null;
  }

  private class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
