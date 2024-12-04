package homework.VeryDynamic;

import examples.Dynamic.DynamicArray;

public class VeryDynamicArray extends DynamicArray {

    public void deleteElementAt(int index) {
        if (index > size) {
            return;
        }

        for (int i = index; i < currentIndex - 1; i++) {
            values[i] = values[i + 1];
        }

        currentIndex--;
        values[currentIndex] = 0;

        if ((int) (size * 0.25) == currentIndex) {
            int newSize = size / 2;

            int[] newArray = new int[newSize];
            for (int i = 0; i < newSize; i++) {
                newArray[i] = values[i];
            }

            size = newSize;
            values = newArray;
        }
    }

    public static void main(String[] args) {
        var array = new VeryDynamicArray();

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);

        array.deleteElementAt(0);
        array.deleteElementAt(1);
        array.deleteElementAt(2);
        array.deleteElementAt(3);
        array.deleteElementAt(4);
    }
}
