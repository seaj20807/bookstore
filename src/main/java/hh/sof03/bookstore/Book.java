package hh.sof03.bookstore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    private String author;
    @Column(name = "published")
    private Integer year;
    private String isbn;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Book() {
    }

    public Book(String title, String author, Integer year, String isbn) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    public Book(String title, String author, Integer year, String isbn, Category category) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.category = category;
    }

    public Book(String title, String author, Integer year, String isbn, Double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }

    public Book(Long bookId, String title, String author, Integer year, String isbn, Double price, Category category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    public Long getBookId() {
        return bookId;
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

    public Category getCategory() {
        return category;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn="
                + isbn + ", price=" + price + ", category=" + category.getName() + "]";
    }

}
