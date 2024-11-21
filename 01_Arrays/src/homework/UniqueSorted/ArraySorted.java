package homework.UniqueSorted;

class ArraySorted {

    /**
     * @see Printer#printPhoneInfo(long phone, int count)
     */
    static void groupAndPrint(long[] phoneNumbers, Printer printer) {

        long prevNumber = phoneNumbers[0];
        int step = 1;

        for (int i = 1; i < phoneNumbers.length; i++) {
            if (prevNumber != phoneNumbers[i]) {

                printer.printPhoneInfo(prevNumber, step);
                prevNumber = phoneNumbers[i];
                step = 1;
            } else {
                step++;
            }
        }

        printer.printPhoneInfo(prevNumber, step);
    }


    /**
     * @see Printer#printCurrencyInfo(String name, double amount)
     */
    static void cryptoCurrencyAnalysis(String fileContents, Printer printer) {
        System.out.printf("Input file contents: \n%s\n", fileContents);

        String[] lines = fileContents.split("\n");

        var prevCurrencyAmount = MapToCurrencyAmount(lines[0]);
        var sum = prevCurrencyAmount.amount;
        int step = 1;

        for (int i = 1; i < lines.length; i++) {
            var currencyAmount = MapToCurrencyAmount(lines[i]);

            if (!currencyAmount.name.equals(prevCurrencyAmount.name)) {

                printer.printCurrencyInfo(prevCurrencyAmount.name, (double) sum / step);
                prevCurrencyAmount = currencyAmount;

                step = 1;
                sum = prevCurrencyAmount.amount;
            } else {
                step++;
                sum += currencyAmount.amount;
            }
        }

        printer.printCurrencyInfo(prevCurrencyAmount.name, (double) sum / step);
    }

    private static CurrencyAmount MapToCurrencyAmount(String line) {
        var parsedString = line.split(":");

        return new CurrencyAmount(parsedString[0].trim(), Integer.parseInt(parsedString[1].trim()));
    }

    private static class CurrencyAmount {
        String name;
        int amount;

        CurrencyAmount(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }
    }
}
