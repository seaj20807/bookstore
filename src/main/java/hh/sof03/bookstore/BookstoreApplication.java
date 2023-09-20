package hh.sof03.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository) {
		return (args) -> {
			log.info("Save a few books");
			Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "1827184", 15.00);
			Book book2 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1968, "1487587", 30.00);
			Book book3 = new Book("The Way of Kings", "Brandon Sanderson", 2010, "978-0-7653-2635-5", 20.00);
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);

			log.info("List all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
