package ch.authenticit.study.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues<E> {

    private final Queue<E> queue1 = new LinkedList<>();
    private final Queue<E> queue2 = new LinkedList<>();

    private int count = 0;
    private E lastElement;

    public void push(E item) {
        // O(1)
        if (queue2.isEmpty())
            queue1.add(item);
        else
            queue2.add(item);

        lastElement = item;
        count++;
    }

    public E pop() {
        if (isEmpty())
            throw new IllegalStateException("Cannot pop from an empty Stack");

        // O(n)
        return removeLastElement(queue1, queue2);
    }

    public E peek() {
        if (isEmpty())
            throw new IllegalStateException("Cannot peek from an empty Stack");

        // O(1)
        return lastElement;
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public int size() {
        if (queue1.isEmpty())
            return queue2.size();

        return queue1.size();
    }

    @Override
    public String toString() {
        if (queue1.isEmpty())
            return queue2.toString();

        return queue1.toString();
    }

    private E removeLastElement(Queue<E> queue1, Queue<E> queue2) {
        Queue<E> sourceQueue = queue1.isEmpty() ? queue2 : queue1;
        Queue<E> destinationQueue = queue1.isEmpty() ? queue1 : queue2;

        E secondLastElement = null;

        while (sourceQueue.size() > 1) {
            secondLastElement = sourceQueue.remove();
            destinationQueue.add(secondLastElement);
        }

        this.lastElement = secondLastElement;
        E removedElement = sourceQueue.remove();
        count--;

        return removedElement;
    }
}
