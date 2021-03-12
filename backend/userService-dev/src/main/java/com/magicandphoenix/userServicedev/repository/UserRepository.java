package com.magicandphoenix.userServicedev.repository;

import com.magicandphoenix.userServicedev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
