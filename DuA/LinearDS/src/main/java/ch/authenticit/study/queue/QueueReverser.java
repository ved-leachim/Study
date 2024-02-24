package ch.authenticit.study.queue;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueReverser<E> {
    public Queue<E> reverse(Queue<E> queue, int k) {
        var stack = new Stack<E>();
        for (int i = 1; i <= k; i++) {
            if (!queue.isEmpty())
                stack.push(queue.remove());
        }

        var reversedQueue = new LinkedBlockingQueue<E>();
        while (!stack.isEmpty())
            reversedQueue.add(stack.pop());

        while (!queue.isEmpty())
            reversedQueue.add(queue.remove());

        return reversedQueue;
    }
}
