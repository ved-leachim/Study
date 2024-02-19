package ch.authenticit.study.queue;

public interface IQueue {
     public void enqueue(int item);

     public int dequeue();

     public int peek();

     public boolean isEmpty();
     public boolean isFull();
}
