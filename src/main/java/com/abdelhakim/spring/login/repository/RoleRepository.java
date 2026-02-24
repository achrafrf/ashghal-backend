package com.abdelhakim.spring.login.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository; // Import MongoDB
import com.abdelhakim.spring.login.models.ERole;
import com.abdelhakim.spring.login.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> { // extends MongoRepository
  Optional<Role> findByName(ERole name);
}