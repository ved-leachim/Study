package ch.authenticit.study.stack;

public class ArrayStack implements IStack {

    private int[] items;
    private int count = 0;

    public ArrayStack(int size) {
        items = new int[size];
    }

    @Override
    public void push(int item) {
        if (count == items.length) {
            var newArray = new int[count * 2];
            for (int i = 0; i < items.length; i++)
                newArray[i] = items[i];

            items = newArray;
        }
        items[count++] = item;
    }

    @Override
    public int pop() {
        if (isEmpty())
            throw new IllegalStateException("Cannot delete from an empty Stack.");

        return items[--count];
    }

    @Override
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Cannot peek from an empty Stack.");

        return items[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
