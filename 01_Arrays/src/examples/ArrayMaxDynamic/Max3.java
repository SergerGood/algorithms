package examples.ArrayMaxDynamic;

import static java.lang.System.out;

class Max3 {
    public static void main(String[] args) {
        int ageMom = 39;
        int ageDad = 41;
        int maxAge = Math.max(ageMom, ageDad);
        int ageGrandma = 63;
        maxAge = Math.max(maxAge, ageGrandma);
        out.printf("MaxAge = %d\n", maxAge);
    }
}
