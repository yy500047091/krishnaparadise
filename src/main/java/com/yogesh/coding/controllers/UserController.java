package com.yogesh.coding.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.yogesh.coding.dao.UserRepo;
import com.yogesh.coding.entities.User;
import com.yogesh.coding.exceptions.ResourceNotFoundException;
import com.yogesh.coding.payloads.ApiResponse;
import com.yogesh.coding.payloads.UserDto;
import com.yogesh.coding.services.UserService;
@Valid
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	

	
	//pos
	@PostMapping("/")
    public ResponseEntity<UserDto> createUser( @Valid @RequestBody UserDto userDto){
		UserDto createUserDto= this.userService.createUser(userDto);
		
		return new ResponseEntity<UserDto>(createUserDto,HttpStatus.CREATED);
				
    	
    }
	
	
	
	//PUT
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid) {
		UserDto updatedUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	
	//DELETE
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}
	
	
	
	//GET
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser( @PathVariable("userId") Integer uid) {
	

		return ResponseEntity.ok(this.userService.getUserById(uid));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	

}
