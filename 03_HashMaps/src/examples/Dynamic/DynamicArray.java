package examples.Dynamic;

public class DynamicArray {
    protected int[] values = new int[8];
    protected int size = 8;
    protected int currentIndex = 0;

    public void add(int value) {
        values[currentIndex] = value;
        currentIndex++;
        if (currentIndex == size) {
            resize(size * 2);
        }
    }

    public void resize(int newSize) {
        int[] newValues = new int[newSize];
        for (int i = 0; i < size; i++) {
            newValues[i] = values[i];
        }
        values = newValues;
        size = newSize;
    }
}
