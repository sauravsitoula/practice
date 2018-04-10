package com.texas.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
