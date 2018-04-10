package com.texas.practice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.texas.practice.response.UserResponse;
import com.texas.practice.dto.userDto;
import com.texas.practice.service.UserService;


@RestController
@Controller
@RequestMapping("/practise")
public class UserController {
@Autowired
UserService userService;

@RequestMapping(method=RequestMethod.POST)
public ResponseEntity<Object> createUser(@RequestBody userDto userdto){
	userService.createUser(userdto);		
	return new ResponseEntity<Object>(HttpStatus.CREATED);
}
@RequestMapping(value = "/{id}", method = RequestMethod.GET)
public ResponseEntity<Object> readUser(@PathVariable Long id){
	UserResponse userResponse = userService.getUser(id);
	Map<Object, Object> responseMap = new HashMap<Object, Object>();
	responseMap.put("response",userResponse);
	return new ResponseEntity<Object>(responseMap, HttpStatus.OK);
}


}
