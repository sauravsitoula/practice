package com.texas.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.practice.dto.userDto;
import com.texas.practice.model.userModel;
import com.texas.practice.repository.UserRepository;
@Service
public class UserService {
	@Autowired 
	UserRepository userRepository;
	public void createUser(userDto userdto) {
		userModel user = new userModel();
		user.setId(userdto.getId());
		user.setName(userdto.getName());
		user.setPassword(userdto.getPassword());
		userRepository.save(user);
	}
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}
}
