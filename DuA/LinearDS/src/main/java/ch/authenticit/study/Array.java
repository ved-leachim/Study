package ch.authenticit.study;

public class Array {

  private int[] items;
  private int count = 0;

  public Array(int length) {
    items = new int[length];
  }

  public void print() {
    for (int i = 0; i < count; i++) {
      System.out.println(items[i]);
    }
  }

  public void insert(int item) {
    if (items.length == count)
      items = growArray(items);

    items[count++] = item;
  }

  public void removeAt(int index) {
    if (index < 0 || index >= count)
      throw new IllegalArgumentException();

    for (int i = index; i < count; i++)
      items[i] = items[i + 1];

    count--;
  }

  public int indexOf(int item) {
    for (int i = 0; i < items.length; i++)
      if (items[i] == item)
        return i;

    return -1;
  }

  public int max() {
    if (count == 0)
      throw new IllegalArgumentException();

    int max = items[0];
    // O(n)
    for (int i = 0; i < count; i++) {
      if (max < items[i])
        max = items[i];
    }
    return max;
  }

  public Array intersect(Array secondArray) {
    Array intersect = new Array(10);

    // O(nˆ2)
    for (int i = 0; i < count; i++) {
      for (int j = 0; j < secondArray.count; j++) {
        if (items[i] == secondArray.items[j]) {
          intersect.insert(items[i]);
        }
      }
    }
    return intersect;
  }

  public Array reverse() {
    var reverse = new Array(count);

    // O(n)
    for (int i = count - 1; i >= 0; i--)
      reverse.insert(items[i]);

    return reverse;
  }

  public void insertAt(int item, int index) {
    if (items.length == count)
      items = growArray(items);

    for (int i = count; i > index; i--)
      items[i] = items[i - 1];

    items[index] = item;
    count++;
  }

  private int[] growArray(int[] origin) {
    var resized = new int[origin.length * 2];
    for (int i = 0; i < origin.length; i++)
      resized[i] = origin[i];

    return resized;
  }
}
