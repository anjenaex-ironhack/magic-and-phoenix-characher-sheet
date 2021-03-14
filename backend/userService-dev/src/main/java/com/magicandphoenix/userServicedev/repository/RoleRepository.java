package com.magicandphoenix.userServicedev.repository;

import com.magicandphoenix.userServicedev.enums.ERole;
import com.magicandphoenix.userServicedev.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
