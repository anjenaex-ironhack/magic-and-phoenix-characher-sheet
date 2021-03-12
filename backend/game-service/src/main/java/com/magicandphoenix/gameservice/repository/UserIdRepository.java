package com.magicandphoenix.gameservice.repository;

import com.magicandphoenix.gameservice.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIdRepository extends JpaRepository<UserId, Long> {
}
