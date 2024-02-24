package ch.authenticit.study.queue;

import java.util.LinkedList;

public class LinkedListQueue<E> {

    private final LinkedList<E> linkedList = new LinkedList<>();

    public void enqueue(E item) {
        // O(1)
        linkedList.add(item);
    }

    public E dequeue() {
        // O(1)
        return linkedList.remove();
    }

    public E peek() {
        // O(1)
        return linkedList.getFirst();
    }

    public boolean isEmpty() {
        // O(1)
        return linkedList.isEmpty();
    }

    public int size() {
        // O(1)
        return linkedList.size();
    }

    @Override
    public String toString() {
        // O(n)
        return linkedList.toString();
    }
}
