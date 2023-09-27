package hh.sof03.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/index") // Etusivu
    public String index() {
        return "index"; // index.html
    }

    @RequestMapping("/booklist") // Listataan kaikki kirjat
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist"; // booklist.html
    }

    @RequestMapping("/addbook") // Luodaan uusi kirja
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook"; // addbook.html
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST) // Tallennetaan uusi kirja tai kirjan muokkaukset
                                                                  // tietokantaan
    public String save(Book book) {
        repository.save(book);
        return "redirect:/booklist"; // Uudelleenohjaus booklist.html
    }

    @RequestMapping("/delete/{bookId}") // Poistetaan kirja tietokannasta
    public String deleteBook(@PathVariable("bookId") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:/booklist"; // Uudelleenohjaus booklist.html
    }

    @RequestMapping("/edit/{bookId}") // Muokataan olemassaolevaa kirjaa
    public String editBook(@PathVariable("bookId") Long bookId, Model model) {
        model.addAttribute("bookId", repository.findById(bookId));
        return "editbook"; // editbook.html
    }

}
