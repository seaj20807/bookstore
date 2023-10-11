package hh.sof03.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository,
			UserRepository userRepository) {
		return (args) -> {

			log.info("Save a few categories");
			Category category1 = new Category("Fantasy");
			Category category2 = new Category("Sci-fi");
			Category category3 = new Category("Fiction");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			log.info("List all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

			log.info("Save a few books");
			Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "1827184", category1);
			Book book2 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1968, "1487587", category1);
			Book book3 = new Book("The Way of Kings", "Brandon Sanderson", 2010, "978-0-7653-2635-5", category1);
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);

			log.info("List all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

			log.info("Save a few users");
			User user1 = new User("user", "$2a$10$F.BY5Fk2rdPFS2p6vCdh9ON3NCU1yhBLsKBU4ExHgeigBVWkmpb5a", "USER");
			User user2 = new User("admin", "$2a$10$yV0noBYccpkKxxz0hgn7qelEflCSlCPnqWuN1eY8hpkctf3.f3cBS", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

		};
	}

}
