package ch.authenticit.study;

import ch.authenticit.study.queue.ArrayPriorityQueue;
import ch.authenticit.study.queue.ArrayQueue;
import ch.authenticit.study.queue.StackQueue;

public class Main {
    public static void main(String[] args) {
        var apq = new ArrayPriorityQueue(5);
        System.out.println(apq.isEmpty());
        apq.enqueue(30);
        apq.enqueue(20);
        apq.enqueue(10);
        apq.enqueue(50);
        System.out.println(apq.dequeue());
        apq.enqueue(40);
        System.out.println(apq.dequeue());
        System.out.println(apq.isEmpty());
        System.out.println(apq.isFull());
        apq.enqueue(10);
        apq.enqueue(5);
        System.out.println(apq);
        apq.dequeue();
        apq.dequeue();
        apq.enqueue(20);
        apq.enqueue(30);
        System.out.println(apq);
        apq.dequeue();
        apq.dequeue();
        apq.dequeue();
        apq.dequeue();
        apq.enqueue(15);
        apq.enqueue(-5);
        System.out.println(apq);
        apq.enqueue(20);
        apq.enqueue(99);
        System.out.println(apq.isFull());
        System.out.println(apq);
    }
}
