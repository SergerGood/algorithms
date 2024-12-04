package homework.HashMapsAreFast;

public class HashMapsAreFast {

    // Порядок номеров в массиве с уникальными номерами, согласно их первому появлению в массиве номеров по порядку.
    public long[] getUniqueNumbers(long[] inputArray) {
        int length = inputArray.length;
        var index = 0;
        while (index < inputArray.length) {

            var found = false;
            var foundIndex = -1;
            for (int k = index + 1; k < length; k++) {
                if (inputArray[k] == inputArray[index]) {
                    found = true;
                    foundIndex = k;
                    break;
                }
            }

            if (!found) {
                index++;
            } else {
                for (int k = foundIndex + 1; k < length; k++) {
                    inputArray[k - 1] = inputArray[k];
                }
                length--;
            }
        }

        var newArray = new long[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = inputArray[i];
        }

        return newArray;
    }


    public boolean isThereTwoNumbers(int[] numbers, int X) {
        HashMap map = new HashMap();

        for (int number : numbers) {

            int otherNumber = X - number;
            if (number != otherNumber && map.get(otherNumber)) {
                return true;
            }

            if (!map.get(number)) {
                map.add(number, true);
            }
        }

        return false;


    }

    public class HashMap {

        class KeyValuePair {
            public int key;
            public boolean value;

            public KeyValuePair(int key, boolean value) {
                this.value = value;
                this.key = key;
            }
        }

        KeyValuePair[] entries = new KeyValuePair[8];
        int size = 8;
        int numberOfElements = 0;

        int getHash(int key) {
            return Math.abs(key ^ (key >>> 16));
        }

        public boolean get(int key) {
            int index = findGoodIndex(key);
            if (index == -1) {
                return  false;
            }

            KeyValuePair entry = entries[index];
            if (entry == null) {
                return false;
            }

            return entry.value;
        }

        public void add(int key, boolean value) {
            int index = findGoodIndex(key);

            entries[index] = new KeyValuePair(key, value);
            numberOfElements++;

            if (numberOfElements == size) {
                resize(size * 2);
            }
        }

        public void resize(int newSize) {
            KeyValuePair[] newEntries = new KeyValuePair[newSize];

            for (int i = 0; i < size; i++) {
                KeyValuePair entry = entries[i];
                int index = findGoodIndex(entry.key);
                newEntries[index] = entry;
            }
            entries = newEntries;
            size = newSize;
        }

        int findGoodIndex(int key) {
            int hash = getHash(key);
            int index = hash % size;

            for (int i = 0; i < size; i++) {
                int probingIndex = (index + i) % size;
                KeyValuePair entry = entries[probingIndex];
                if (entry == null || entry.key == key) {
                    return probingIndex;
                }
            }
            return -1;
        }
    }
}
