package com.example.Bookstore;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.UserPerson;
import com.example.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class UserRepositoryTest {
	@Autowired
	private UserRepository urepository;

	@Test
	public void createNewUser() {
		UserPerson users = new UserPerson("lion", "$2y$12$REhu9711ZeCHEOImaNFLvOgYf5ZCVpQl3FJz8FU/NrAaRFQsu6.5C", "lion@lion.fi", "USER");
		urepository.save(users);
		
		assertNotNull(users);
	}
	
	@Test
	public void findUserByEmail() {
		UserPerson users = urepository.findByUsername("cat");

		assertThat(users.getEmail()).isEqualTo("cat@cat.com");
	}
	
	@Test
	public void deleteUser() {
		UserPerson users = urepository.findByUsername("cat");
		
		urepository.deleteById(users.getId());
		assertThat(urepository.count()).isEqualTo(1);
	}
	
}
