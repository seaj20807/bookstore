package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.web.BookController;
import hh.sof03.bookstore.web.BookRestController;
import hh.sof03.bookstore.web.CategoryController;
import hh.sof03.bookstore.web.UserDetailServiceImpl;

// //@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private BookRestController bookRestController;

	@Autowired
	private CategoryController categoryController;

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(bookRestController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(userDetailServiceImpl).isNotNull();
	}

}
