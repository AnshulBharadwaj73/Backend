package com.example.demo.Repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByEmail(String email);

    Optional<User> findOneByEmailAndPassword(String email,String password);
}
