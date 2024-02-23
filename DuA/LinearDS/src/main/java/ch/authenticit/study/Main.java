package ch.authenticit.study;

import ch.authenticit.study.queue.ArrayQueue;
import ch.authenticit.study.queue.StackQueue;

public class Main {
    public static void main(String[] args) {
        var arrQueue = new StackQueue();
        arrQueue.enqueue(10);
        arrQueue.enqueue(20);
        arrQueue.enqueue(30);
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.peek());

        arrQueue.enqueue(40);
        arrQueue.enqueue(50);
        System.out.println(arrQueue.isFull());
        arrQueue.enqueue(60);
        System.out.println(arrQueue.isFull());
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.dequeue());
        arrQueue.enqueue(70);
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.isEmpty());
        arrQueue.enqueue(80);
        System.out.println(arrQueue.isEmpty());
    }
}
