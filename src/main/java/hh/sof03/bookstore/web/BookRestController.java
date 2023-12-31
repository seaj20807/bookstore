package hh.sof03.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    // Listataan kaikki kirjat, REST
    @GetMapping("/books")
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) bookRepository.findAll();
    }

    // Haetaan kirja sen ID:llä, REST
    @GetMapping("/books/{bookId}")
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("bookId") Long bookId) {
        return bookRepository.findById(bookId);
    }

    // Tallennetaan uusi kirja, REST
    @PostMapping("/books")
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Poistetaan kirja, REST
    @DeleteMapping("/books/{bookId}")
    public void deleteBookRest(@PathVariable("bookId") Long bookId) {
        bookRepository.deleteById(bookId);
    }

}
