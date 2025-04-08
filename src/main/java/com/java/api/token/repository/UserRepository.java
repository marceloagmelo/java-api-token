package com.java.api.token.repository;

import com.java.api.token.entity.Cliente;
import com.java.api.token.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select id, username, password from users where username = :username", nativeQuery = true)
    User findByUsername(String username);

    @Query(value = "select id, username, password from users where id = :id", nativeQuery = true)
    User findByIdUser(Integer id);
}
