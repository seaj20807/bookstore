package hh.sof03.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @RequestMapping("/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist"; // categorylist.html
    }

    @RequestMapping("/addcategory") // Luodaan uusi kategoria
    public String addBook(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; // addcategory.html
    }

    @RequestMapping(value = "/savecategory", method = RequestMethod.POST) // Tallennetaan uusi kategoria tietokantaan
    public String save(Category category) {
        repository.save(category);
        return "redirect:/categorylist"; // Uudelleenohjaus endpointiin ../categorylist.html
    }

}
