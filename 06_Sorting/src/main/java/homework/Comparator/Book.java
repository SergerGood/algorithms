package homework.Comparator;

public class Book implements Comparable<Book>{
    private final String title;
    private final String author;
    private final int year;
    private final double price;

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Book book) {
        int compareAuthor = this.getAuthor().compareTo(book.getAuthor());
        if (compareAuthor != 0) {
            return compareAuthor;
        }

        int compareTitle = this.getTitle().compareTo(book.getTitle());
        if (compareTitle != 0) {
            return compareTitle;
        }

        if (this.getYear() == book.getYear() && this.getPrice() == book.getPrice()) {
            return 0;
        }

        if (this.getYear() == book.getYear()) {
            if (this.getPrice() < book.getPrice()) {
                return -1;
            } else {
                return 1;
            }
        } else {
            if (this.getYear() < book.getYear()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
