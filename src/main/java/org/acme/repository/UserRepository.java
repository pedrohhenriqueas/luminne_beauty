package org.acme.repository;

import org.acme.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
