package homework.Comparator;

public class BookComparator {
    //Реализовать сравнение книг только по цене, вначале самые дешевые
    public static int compareBooksByPrice(Book first, Book second) {
        if (first.getPrice() < second.getPrice()) {
            return -1;
        } else if (first.getPrice() > second.getPrice()) {
            return 1;
        }
        return 0;
    }

    //Реализовать сравнение книг вначале по автору, потом по названию, затем по году публикации
    public static int compareBooksByAuthorAndTitleAndYear(Book first, Book second) {
        int compareAuthor = first.getAuthor().compareTo(second.getAuthor());
        int compareTitle = first.getTitle().compareTo(second.getTitle());

        if (compareAuthor == 0 && compareTitle == 0) {
            return compareBooksByYear(first, second);
        } else if (compareAuthor == 0) {
            return compareTitle;
        } else {
            return compareAuthor;
        }
    }

    private static int compareBooksByYear(Book first, Book second) {
        if (first.getYear() < second.getYear()) {
            return -1;
        } else if (first.getYear() > second.getYear()) {
            return 1;
        }
        return 0;
    }
}
