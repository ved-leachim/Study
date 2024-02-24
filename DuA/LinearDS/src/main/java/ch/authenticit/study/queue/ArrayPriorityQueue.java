package ch.authenticit.study.queue;

import java.util.Arrays;

public class ArrayPriorityQueue implements IQueue {
    private final int[] items;
    private int front = 0;
    private int rear = 0;
    private int count = 0;
    private final int size;

    public ArrayPriorityQueue(int size) {
        this.size = size;
        items = new int[size];
    }

    @Override
    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException("Cannot enqueue on a full Queue");

        if (isEmpty()) {
            items[rear++] = item;
            rear = rear % size;
            count++;
            return;
        }

        var current = Math.floorMod((rear - 1), size);

        while (current != rear) {
            // shift items and move current
            if (items[current] > item) {
                items[(current + 1) % size] = items[current];
                current = Math.floorMod((current - 1), size);
                continue;
            }
            // insert item
            items[(current + 1) % size] = item;
            rear = (rear + 1) % size;
            count++;
            return;
        }
        // insert at the front, Queue is now full
        items[front] = item;
        rear = (rear + 1) % size;
        count++;
    }

    @Override
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Cannot dequeue on an empty Queue");

        var val = items[front];
        items[front] = 0;
        front++;
        front = front % size;
        count--;

        return val;
    }

    @Override
    public int peek() {
        return items[front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

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
