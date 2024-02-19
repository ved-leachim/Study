package ch.authenticit.study.queue;

import java.util.Queue;
import java.util.Stack;

public class QueueOperator {

    public static void reverse (Queue<Integer> queue) {
        var stack = new Stack<Integer>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        System.out.println(queue);
    }
}
