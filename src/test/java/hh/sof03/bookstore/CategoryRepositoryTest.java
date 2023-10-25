package hh.sof03.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findAllCategoriesShouldReturnCategory() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        assertThat(categories).hasSize(3);
        assertThat(categories.get(0).getName()).isEqualTo("Fantasy");
    }

    @Test
    public void createNewCategory() {
        Category category = new Category("Romance");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    public void deleteCategory() {
        Category category = new Category("Romance");
        categoryRepository.save(category);
        assertThat(categoryRepository.count()).isEqualTo(4);
        categoryRepository.delete(category);
        assertThat(categoryRepository.count()).isEqualTo(3);
    }

}
