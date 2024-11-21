package homework.UniqueSorted;

class Printer {
    public void printPhoneInfo(long phone, int count) {
        System.out.printf("+%d — поступило заявок: %d\n", phone, count);
    }
    void printCurrencyInfo(String name, double amount)  {
        System.out.printf("%s: %.3f\n", name, amount);
    }
}
