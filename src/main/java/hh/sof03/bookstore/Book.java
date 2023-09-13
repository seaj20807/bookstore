package hh.sof03.bookstore;

public class Book {

    private String title;
    private String author;
    private Integer year;
    private String isbn;
    private Double price;

    public Book() {
    }

    public Book(String title, String author, Integer year, String isbn, Double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
                + "]";
    }

}