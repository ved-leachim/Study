package ch.authenticit.study;

import ch.authenticit.study.queue.ArrayQueue;

public class Main {
    public static void main(String[] args) {
        var arrQueue = new ArrayQueue(5);
        arrQueue.enqueue(10);
        arrQueue.enqueue(20);
        arrQueue.enqueue(30);
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.peek());
        System.out.println(arrQueue);

        arrQueue.enqueue(40);
        arrQueue.enqueue(50);
        System.out.println(arrQueue.isFull());
        System.out.println(arrQueue);
        arrQueue.enqueue(60);
        System.out.println(arrQueue);
        System.out.println(arrQueue.isFull());
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue);
        arrQueue.enqueue(70);
        System.out.println(arrQueue);
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.dequeue());
        System.out.println(arrQueue.isEmpty());
        arrQueue.enqueue(80);
        System.out.println(arrQueue);
    }
}
