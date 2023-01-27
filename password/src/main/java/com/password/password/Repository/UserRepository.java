package com.password.password.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.password.password.model.user;

public interface UserRepository extends JpaRepository<user, Long> {
}