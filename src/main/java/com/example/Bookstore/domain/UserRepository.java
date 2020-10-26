package com.example.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserPerson, Long> {
	UserPerson findByUsername(String username);
}
