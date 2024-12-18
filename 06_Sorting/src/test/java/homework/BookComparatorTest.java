package homework;

import homework.Comparator.Book;
import homework.Comparator.BookComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class BookComparatorTest {
    static List<Book> algoBooks =
            List.of(
                    new Book("Грокаем алгоритмы", "Адитья Бхаргава", 2017, 500.0),
                    new Book("Совершенный алгоритм. Основы", "Тим Рафгарден", 2019, 1500.0),
                    new Book("Совершенный алгоритм. Графовые алгоритмы и структуры данных", "Рафгарден Тим", 2019, 999.0),
                    new Book("Алгоритмы для начинающих", "Луридас Панос", 2018, 499.0),
                    new Book("Грокаем алгоритмы", "Адитья Бхаргава", 2021, 700.0),
                    new Book("Введение в анализ алгоритмов", "Майкл Солтис", 2019, 500.0),
                    new Book("Алгоритмы: разработка и применение", "Джон Клейнберг", 2016, 100.0)

            );

    @Test
    @DisplayName("Sort books by price")
    void compareBooksByPriceTest() {
        var sortedBooks = algoBooks.stream().sorted(BookComparator::compareBooksByPrice).collect(Collectors.toList());
        var expectedList = algoBooks.stream().sorted(Comparator.comparingDouble(Book::getPrice)).collect(Collectors.toList());
        assertIterableEquals(expectedList, sortedBooks);
    }

    @Test
    @DisplayName("Sort books by author, title, year")
    void compareBooksByAuthorAndYearAndPriceTest() {
        var sortedBooks = algoBooks.stream().sorted(BookComparator::compareBooksByAuthorAndTitleAndYear).collect(Collectors.toList());
        var expectedList = algoBooks.stream()
                .sorted(Comparator.comparing(Book::getAuthor)
                        .thenComparing(Book::getTitle)
                        .thenComparingInt(Book::getYear))
                .collect(Collectors.toList());
        assertIterableEquals(expectedList, sortedBooks);
    }

    @Test
    @DisplayName("Sort books by price")
    void bookCompareToTest() {
        var sortedBooksCount = algoBooks.stream().sorted().collect(Collectors.toCollection(TreeSet::new)).size();
        var expectedCount = algoBooks.size();
        assertEquals(expectedCount, sortedBooksCount);
    }
}
