package hh.sof03.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    // Listataan kaikki kategoriat
    @RequestMapping("/categorylist")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist"; // categorylist.html
    }

    // Luodaan uusi kategoria
    @RequestMapping("/addcategory") // Luodaan uusi kategoria
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addBook(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; // addcategory.html
    }

    // Tallennetaan uusi kategoria tietokantaan
    @RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String save(Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist"; // Uudelleenohjaus endpointiin ../categorylist.html
    }

    // Poistetaan kategoria tietokannasta
    @RequestMapping(value = "/deletecategory/{categoryId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteCategory(@PathVariable("categoryId") Long categoryId, Model model) {
        categoryRepository.deleteById(categoryId);
        return "redirect:/categorylist"; // Uudelleenohjaus endpointiin ../categoylist.html
    }

}
