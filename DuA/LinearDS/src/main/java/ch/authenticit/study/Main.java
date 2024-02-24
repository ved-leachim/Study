package ch.authenticit.study;

import ch.authenticit.study.queue.ArrayPriorityQueue;
import ch.authenticit.study.queue.ArrayQueue;
import ch.authenticit.study.queue.QueueReverser;
import ch.authenticit.study.queue.StackQueue;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        var queue = new LinkedBlockingQueue<Integer>() {
            {
                add(10);
                add(20);
                add(30);
                add(40);
                add(50);
            }
        };
        var queueReverser = new QueueReverser<Integer>();

        var partiallyReversedQueue = queueReverser.reverse(queue, 3);
        System.out.println(partiallyReversedQueue);
    }
}
