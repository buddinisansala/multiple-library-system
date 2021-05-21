package com.buddhi.multiplelibrary.repository;

import com.buddhi.multiplelibrary.comman.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String userName);
}
