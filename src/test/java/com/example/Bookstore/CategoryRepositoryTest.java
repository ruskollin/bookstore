package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository crepository;

	@Test
	public void createNewCategory() {
		Category categories = new Category("Thriller");
		crepository.save(categories);
		
		assertNotNull(categories);
	}
	
	@Test
	public void findCategoryByName() {
		List<Category> categories= crepository.findByName("Action and Adventure");

		assertThat(categories.get(0).getName()).isEqualTo("Action and Adventure");
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categories = crepository.findByName("Mystery");
		
		crepository.deleteById(categories.get(0).getCategoryid());
		assertThat(crepository.count()).isEqualTo(9);
	}
}
