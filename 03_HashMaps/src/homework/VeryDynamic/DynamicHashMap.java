package homework.VeryDynamic;

import examples.Dynamic.HashMap;

public class DynamicHashMap extends HashMap {
    public void deleteKey(String key) {
        int index = findGoodIndex(key);
        if (index == -1) {
            return;
        }
        KeyValuePair entry = entries[index];
        if (entry == null) {
            return;
        }

        entries[index] = null;
        numberOfElements--;

        if ((int) (size * 0.25) == numberOfElements) {

            int newSize = size / 2;
            KeyValuePair[] newEntries = new KeyValuePair[newSize];

            for (int i = 0; i < size; i++) {
                KeyValuePair foundEntry = entries[i];
                int foundIndex = findGoodIndex(foundEntry.key);
                newEntries[foundIndex] = foundEntry;
            }

            entries = newEntries;
            size = newSize;
        }
    }

    public String[] getAllKeys() {

        var keys = new String[size];
        var step = 0;

        for (int i = 0; i < size; i++) {
            KeyValuePair entry = entries[i];
            if (entry != null) {
                keys[step] = entry.key;
                step++;
            }
        }

        var array = new String[step];
        for (int i = 0; i < array.length; i++) {
            array[i] = keys[i];
        }

        return array;
    }

    public String[] getAllValues() {

        var values = new String[size];
        var step = 0;

        for (int i = 0; i < size; i++) {
            KeyValuePair entry = entries[i];
            if (entry != null) {
                values[step] = entry.value;
                step++;
            }
        }

        var array = new String[step];
        for (int i = 0; i < array.length; i++) {
            array[i] = values[i];
        }

        return array;
    }

    public static void main(String[] args) {
        var dynamicHashMap = new DynamicHashMap();

        dynamicHashMap.add("key1", "value1");
        dynamicHashMap.add("key2", "value2");
        dynamicHashMap.add("key3", "value3");
        dynamicHashMap.add("key4", "value4");
        dynamicHashMap.add("key5", "value5");
        dynamicHashMap.add("key6", "value6");
        dynamicHashMap.add("key7", "value7");
        dynamicHashMap.add("key8", "value8");

        var values = dynamicHashMap.getAllValues();
        var keys = dynamicHashMap.getAllKeys();

        dynamicHashMap.deleteKey("key1");
        dynamicHashMap.deleteKey("key2");
        dynamicHashMap.deleteKey("key3");
        dynamicHashMap.deleteKey("key4");
        dynamicHashMap.deleteKey("key5");
    }
}
