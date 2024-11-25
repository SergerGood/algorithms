package examples.HashFunctions;

public class NamesHash {
    private static int[] values = new int[8];

    public static void main(String[] args) {
        values[2] = 14; // Ия
        values[3] = 99; // Аня
        values[4] = 30; // Миша
        values[5] = 42; // Антон
        values[6] = 87; // Владик
        values[7] = 71; // Николай

    }

    public int getIndexByKey(String key) {
        return key.length();
    }

    public int getValueByKey(String key) {
        int index = getIndexByKey(key);
        return values[index];
    }

}
