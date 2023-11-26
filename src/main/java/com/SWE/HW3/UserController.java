package com.SWE.HW3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SWE.HW3.model.user;
import com.SWE.HW3.service.userService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
//	@Autowired
	private userService userService;

	public UserController(com.SWE.HW3.service.userService userService) {
		super();
		this.userService = userService;
	}
	 
	
	//build create user REST API
	@PostMapping()
	public ResponseEntity<user> saveUser(@RequestBody user User){
//		System.out.print(User);
//		System.out.println("Hi");
		return new ResponseEntity<user>(userService.saveUser(User), HttpStatus.CREATED); 
	}
	
	// build get all user REST API
	@GetMapping
	public List<user> getAllUser(){
		return userService.getAllUsers();
	}
	
	//build get employee by id REST API
	//http://localhost:8080/api/user/1
	@GetMapping("{id}")
	public ResponseEntity<user> getUserById(@PathVariable("id") long studentId){
		return new ResponseEntity<user>(userService.getUserById(studentId), HttpStatus.OK);
	}
	
	
	//build update user REST API
	//http://localhost:8080/api/user/1
	@PutMapping("{id}")
	
	public ResponseEntity<user> updateUser(@PathVariable("id") long id, @RequestBody user User){
		
		return new ResponseEntity<user>(userService.updateUser(User, id), HttpStatus.OK);
	}
	
	@DeleteMapping()
	public ResponseEntity<String> deleteAllUser() {
    	userService.deleteAllUser();
		return new ResponseEntity<String>("Student User deleted successfully", HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable("id") long id) {
//		return new ResponseEntity<String>("Student User deleted successfully", HttpStatus.OK);
		userService.deleteUser(id);
		
	}
}
