package com.user.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.User;
import com.user.UserNotFoundException;
import com.user.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> retrieveAllUser() {
		return userRepository.findAll();
	}

	@GetMapping("/user/{id}")
	public User getUserDetails(@PathVariable("id") Integer userId) throws UserNotFoundException
	{  
		return userRepository.findById(userId).get();
	}  

	@DeleteMapping("/user/{id}")
	public void deleteBook(@PathVariable("id") Integer userId) throws UserNotFoundException
	{  
		userRepository.deleteById(userId);
	}  
	
	@PostMapping("/user")
	public String saveUser(@RequestBody @Valid User user) throws UserNotFoundException   
	{  
		userRepository.save(user);  

		return "Successfully added"; 
	}  

	@PutMapping("/user")
	public String update(@RequestBody @Valid User user) throws UserNotFoundException  
	{  

		Optional<User> studentOptional = userRepository.findById(user.getId());

		if (!studentOptional.isPresent())
			return "Not found";

		userRepository.save(user);
		return "Successfully Updated";
	}  


}
