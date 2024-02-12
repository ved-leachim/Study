package ch.authenticit.study;

import java.util.NoSuchElementException;

public class LinkedList {
  private Node first;
  private Node last;
  private int size;

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

    if (first.equals(last))
      first = last = null;
    else {
      first = first.next;
    }

    size--;
  }

  public void deleteLast() {
    if (isEmpty())
      throw new NoSuchElementException("Cannot delete a Node from an empty Linked List");

    if (first.equals(last))
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

    public Node(int value) {
      this.value = value;
    }
  }
}
