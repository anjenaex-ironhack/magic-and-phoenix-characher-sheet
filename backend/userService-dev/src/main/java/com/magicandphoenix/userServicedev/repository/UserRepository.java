package com.magicandphoenix.userServicedev.repository;

import com.magicandphoenix.userServicedev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);

    Boolean existByUsername (String username);

    Boolean existByEmail(String email);

}
