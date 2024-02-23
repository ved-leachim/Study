package ch.authenticit.study.queue;

import java.util.Stack;

public class StackQueue implements IQueue {

    private final Stack<Integer> enqueue = new Stack<>();

    private final Stack<Integer> dequeue = new Stack<>();

    @Override
    public void enqueue(int item) {
        // O(1)
        enqueue.push(item);
    }

    @Override
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Cannot pop from an empty Queue");

        // O(n)
        moveToDequeue();

        return dequeue.pop();
    }

    @Override
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Cannot peek from an empty Queue");

        // O(n)
        moveToDequeue();

        return dequeue.peek();
    }

    @Override
    public boolean isEmpty() {
        return enqueue.isEmpty() && dequeue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    private void moveToDequeue() {
        if (dequeue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
        }
    }
}
