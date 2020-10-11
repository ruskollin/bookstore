package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save books");
			crepository.save(new Category("Action and Adventure"));
			crepository.save(new Category("Comic Book"));
			crepository.save(new Category("Crime"));
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Mystery"));
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Science Fiction"));

			log.info("save a couple of books");
			brepository.save(new Book("Alice in Wonderland", "Lewis Caroll", 1856, "978-1-904808-44-2", 20, crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("Dracula", "Bram Stoker", 1897, "978-1-904808-44-3", 23, crepository.findByName("Horror").get(0)));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
			
			// Create users: admin/admin user/user
			User user1 = new User("cat", "$2y$12$REhu9711ZeCHEOImaNFLvOgYf5ZCVpQl3FJz8FU/NrAaRFQsu6.5C", "cat@cat.fom", "USER");
			User user2 = new User("admin", "$2y$12$KZ6BGeCwoB8.OJzf/4oXR..M0kT8wElTJSwZ8vuiV7DhqdFBxNIda", "admin@admin.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};
	}
}






