package com.texas.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texas.practice.model.userModel;

public interface UserRepository extends JpaRepository<userModel,Long> {


}
