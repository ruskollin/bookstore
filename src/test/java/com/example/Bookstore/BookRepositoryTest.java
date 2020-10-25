package com.example.Bookstore;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;

	@Test
	public void createNewBook() {
		Book books = new Book("The Silence of the Lambs", "Hannibal Lecter", 1988, "278-1-973308-88-3", 26, crepository.findByName("Horror").get(0));
		repository.save(books);
		
		assertNotNull(books);
	}
	
	@Test
	public void findByAuthorShouldReturnTitle() {
		List<Book> books = repository.findByAuthor("Lewis Caroll");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Alice in Wonderland");
	}
	
	@Test
	public void deleteBook() {
		List<Book> books = repository.findByAuthor("Bram Stoker");
		
		repository.deleteById(books.get(0).getId());
		assertThat(repository.count()).isEqualTo(1);
	}
}