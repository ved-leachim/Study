package ch.authenticit.study;

import ch.authenticit.study.queue.*;
import ch.authenticit.study.stack.StackWithTwoQueues;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        var swtq = new StackWithTwoQueues<Integer>();
//        System.out.println(swtq.pop());
        System.out.println(swtq.isEmpty());
        swtq.push(10);
        swtq.push(20);
        swtq.push(30);
        swtq.push(40);
        swtq.push(50);
        System.out.println(swtq.isEmpty());
        System.out.println(swtq.size());
        System.out.println(swtq);
        System.out.println("peek: " + swtq.peek());
        System.out.println(swtq.pop());
        System.out.println(swtq.pop());
        System.out.println(swtq.pop());
        swtq.push(60);
        swtq.push(70);
        System.out.println(swtq);
        System.out.println("peek: " + swtq.peek());
        System.out.println(swtq.pop());
        System.out.println("peek: "+ swtq.peek());
        System.out.println(swtq);
    }
}
