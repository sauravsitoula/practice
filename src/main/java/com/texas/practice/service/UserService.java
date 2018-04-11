package com.texas.practice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public void updateUser(Long id, UserDto userDto) {
		User usermodel = userRepository.getOne(id);
		usermodel.setName(userDto.getName());
		usermodel.setPassword(userDto.getPassword());
		userRepository.save(usermodel);
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
	public Map<Object, Object> getallusers() {
	
		
		List<User> user = userRepository.findAll();
		List<UserResponse> userResponse = new ArrayList();
		for(User u:user) {
			UserResponse response = new UserResponse();
			response.setName(u.getName());
			response.setPassword((u.getPassword()));
		    userResponse.add(response);
		}
		Map<Object, Object> responseMap = new HashMap<Object, Object>();
		responseMap.put("All Users", userResponse);
		return responseMap;
	}
	
}
