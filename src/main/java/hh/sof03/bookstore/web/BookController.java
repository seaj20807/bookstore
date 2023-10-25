package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Kirjautuminen
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login"; // login.html
    }

    // Etusivu
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index"; // index.html
    }

    // Listataan kaikki kirjat
    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String bookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist"; // booklist.html
    }

    // Luodaan uusi kirja
    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook"; // addbook.html
    }

    // Tallennetaan uusi kirja tai kirjan muokkaukset tietokantaan
    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String save(Book book) {
        bookRepository.save(book);
        return "redirect:/booklist"; // Uudelleenohjaus endpointiin ../booklist.html
    }

    // Poistetaan kirja tietokannasta
    @RequestMapping(value = "/deletebook/{bookId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("bookId") Long bookId, Model model) {
        bookRepository.deleteById(bookId);
        return "redirect:/booklist"; // Uudelleenohjaus endpointiin ../booklist.html
    }

    // Muokataan olemassaolevaa kirjaa
    @RequestMapping(value = "/edit/{bookId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editBook(@PathVariable("bookId") Long bookId, Model model) {
        model.addAttribute("book", bookRepository.findById(bookId));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook"; // editbook.html
    }

}
