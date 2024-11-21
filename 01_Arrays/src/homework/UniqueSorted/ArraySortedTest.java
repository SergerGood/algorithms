package homework.UniqueSorted;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ArraySortedTest {
    static Stream<long[]> providerGroupAndPrint() {
        return Stream.of(
                new long[]{
                        79000000000L,
                        79000000000L,
                        79000000001L,
                        79000000002L,
                        79000000002L,
                        79000000003L,
                        79000000003L,
                        79000000003L,
                        79000000003L,
                        79000000004L,
                }
        );
    }

    static Stream<List<CurrencyAmount>> providerCryptoCurrencyAnalysis() {
        return Stream.of(
                Arrays.asList(
                        new CurrencyAmount("BTC", 42),
                        new CurrencyAmount("BTC", 600),
                        new CurrencyAmount("BTC", 900),
                        new CurrencyAmount("DOGE", 123456),
                        new CurrencyAmount("DOGE", 69420),
                        new CurrencyAmount("ETH", 220),
                        new CurrencyAmount("ETH", 666),
                        new CurrencyAmount("XMR", 14),
                        new CurrencyAmount("XMR", 88)
                ),
                Arrays.asList(
                        new CurrencyAmount("BTC", 600),
                        new CurrencyAmount("BTC", 600),
                        new CurrencyAmount("BTC", 600),
                        new CurrencyAmount("BTC", 600),
                        new CurrencyAmount("BTC", 600),
                        new CurrencyAmount("BTC", 600),
                        new CurrencyAmount("BTC", 600)
                ),
                Arrays.asList(
                        new CurrencyAmount("BTC", 1),
                        new CurrencyAmount("DOGE", 2)
                ),
                Collections.singletonList(
                        new CurrencyAmount("DOGE", 69420)
                )
        );
    }

    @DisplayName("Group phone numbers")
    @ParameterizedTest
    @MethodSource("providerGroupAndPrint")
    void groupAndPrintTest(long[] numbers) {
        var printer = new TestPrinter();
        ArraySorted.groupAndPrint(numbers, printer);
        var expected = Arrays.stream(numbers).boxed().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        ConcurrentHashMap::new,
                        Collectors.counting())
        );
        var actual = printer.phoneToCountMap;
        assertEquals(expected, actual);
    }

    @DisplayName("Group phone numbers")
    @ParameterizedTest
    @MethodSource("providerCryptoCurrencyAnalysis")
    void cryptoCurrencyAnalysisTest(List<CurrencyAmount> contents) {
        var printer = new TestPrinter();
        var list = contents.stream().map(CurrencyAmount::toString).collect(Collectors.toList());
        var file = String.join(" \n ", list);
        ArraySorted.cryptoCurrencyAnalysis(file, printer);

        var expected = contents.stream().collect(Collectors.groupingBy(
                CurrencyAmount::getName,
                ConcurrentHashMap::new,
                Collectors.averagingDouble(CurrencyAmount::getAmount)
        ));

        var actual = printer.currencyAverage;

        assertEquals(expected, actual);
    }

    static class CurrencyAmount {
        String name;
        int amount;

        CurrencyAmount(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format("%s:%d", name, amount);
        }

        String getName() {
            return name;
        }


        int getAmount() {
            return amount;
        }


    }

    class TestPrinter extends Printer {
        ConcurrentHashMap<Long, Long> phoneToCountMap = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Double> currencyAverage = new ConcurrentHashMap<>();

        public void printPhoneInfo(long phone, int count) {
            assertFalse(phoneToCountMap.containsKey(phone));
            phoneToCountMap.put(phone, (long) count);
        }

        public void printCurrencyInfo(String name, double amount) {
            assertFalse(currencyAverage.containsKey(name));
            currencyAverage.put(name, amount);
        }
    }
}
