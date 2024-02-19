package ch.authenticit.study.queue;

import java.util.Arrays;

public class ArrayQueue implements IQueue {

    private final int[] items;
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public ArrayQueue(int size) {
        items = new int[size];
    }

    @Override
    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException("Cannot add to a full Queue");
        }

        items[rear++] = item;
        rear = rear % items.length;
        count++;
    }

    @Override
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Cannot remove from an empty Queue");

        var value = items[front++];
        front = front % items.length;
        count--;
        return value;
    }

    @Override
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Cannot peek from an empty Queue;");

        return items[front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        var result = new int[count];

        var starter = front;
        var i = 0;
        do {
            result[i] = items[starter++];
            starter = starter % items.length;
            i++;
        } while (starter != rear);

        return Arrays.toString(result);
    }
}
