package examples.Dynamic;

public class HashMap {
    protected class KeyValuePair {
        public String key;
        public String value;

        public KeyValuePair(String key, String value) {
            this.value = value;
            this.key = key;
        }
    }

    protected KeyValuePair[] entries = new KeyValuePair[8];
    protected int size = 8;
    protected int numberOfElements = 0;

    int hashFunction(String key) {
        //
        return 0;
    }

    public void add(String key, String value) {
        int index = findGoodIndex(key);
        entries[index] = new KeyValuePair(key, value);
        numberOfElements++;
        if (numberOfElements == size) {
            resize(size * 2);
        }
    }

    public void resize(int newSize) {
        // Создать новый массив
        KeyValuePair[] newEntries = new KeyValuePair[newSize];
        // Скопировать 8 элементов из старого массива

        for (int i = 0; i < size; i++) {
            KeyValuePair entry = entries[i];
            int index = findGoodIndex(entry.key);
            newEntries[index] = entry;
        }
        entries = newEntries;
        size = newSize;
    }

    public String get(String key) {
        int index = findGoodIndex(key);
        if (index == -1) {
            return null;
        }
        KeyValuePair entry = entries[index];
        if (entry == null) {
            return null;
        }
        return entry.value;
    }

    protected int findGoodIndex(String key) {
        int hash = hashFunction(key);
        int index = hash % size;

        for (int i = 0; i < size; i++) {
            int probingIndex = (index + i) % size;
            KeyValuePair entry = entries[probingIndex];
            if (entry == null || entry.key.equals(key)) {
                return probingIndex;
            }
        }
        return -1;
    }

}
