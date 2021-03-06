package com.example.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book, Long> {
	
	public List<Book> findByAuthor(String author);

	@Override
	public void deleteById(Long id);
}