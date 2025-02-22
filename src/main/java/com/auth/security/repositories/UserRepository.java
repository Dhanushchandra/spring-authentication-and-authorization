package com.auth.security.repositories;

import com.auth.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(int id);

    User findByEmail(String email);

}
