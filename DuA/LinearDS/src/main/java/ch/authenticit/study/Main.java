package ch.authenticit.study;

import ch.authenticit.study.queue.*;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        var llq = new LinkedListQueue<Integer>();
        llq.enqueue(10);
        llq.enqueue(20);
        llq.enqueue(30);
        llq.enqueue(40);
        llq.enqueue(50);
        System.out.println(llq);
        System.out.println(llq.size());
        System.out.println(llq.dequeue());
        System.out.println(llq.dequeue());
        System.out.println(llq.dequeue());
        System.out.println(llq);
        System.out.println(llq.size());
        llq.enqueue(60);
        llq.enqueue(70);
        System.out.println(llq);
        System.out.println(llq.size());
    }
}
