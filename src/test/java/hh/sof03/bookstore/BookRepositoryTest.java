package hh.sof03.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findAllBooksShouldReturnBook() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        assertThat(books).hasSize(3);
        assertThat(books.get(0).getTitle()).isEqualTo("The Hobbit");
    }

    @Test
    public void createNewBook() {
        Book book = new Book("Tuntematon Sotilas", "Väinö Linna", 1951, "1234567-89");
        bookRepository.save(book);
        assertThat(book.getBookId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        Book book = new Book("Tuntematon Sotilas", "Väinö Linna", 1951, "1234567-89");
        bookRepository.save(book);
        assertThat(bookRepository.count()).isEqualTo(4);
        bookRepository.delete(book);
        assertThat(bookRepository.count()).isEqualTo(3);
    }

}
