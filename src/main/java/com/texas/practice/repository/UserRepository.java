package com.texas.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texas.practice.model.User;

public interface UserRepository extends JpaRepository<User,Long> {


}
