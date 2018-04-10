package com.texas.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.practice.dto.UserDto;
import com.texas.practice.model.User;
import com.texas.practice.repository.UserRepository;
import com.texas.practice.response.UserResponse;

@Service
public class UserService {
	@Autowired 
	UserRepository userRepository;
	public void createUser(UserDto userdto) {
		User user = new User();
		user.setName(userdto.getName());
		user.setPassword(userdto.getPassword());
		userRepository.save(user);
	}

	public UserResponse getUser(Long id) {
		User abcd = userRepository.getOne(id);
	    
		User user = userRepository.getOne(id);
        UserResponse userResponse = new UserResponse();
		userResponse.setName(user.getName());
		userResponse.setPassword(user.getPassword());
		return userResponse;
	}
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}
	
}
