package com.employeedevelopment.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeedevelopment.employee.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User>findByUsername(String username);


}
