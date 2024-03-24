package com.example.demo.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	 @EntityGraph(attributePaths = {"cart"}) // Fetch cart along with the user
	 User findByEmail(String email);

}
