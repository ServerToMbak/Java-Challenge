package com.example.demo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.core.utilities.DataResult;
import com.example.demo.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) 
	{
		this.userService=userService;
	}
		@GetMapping("/getAll")
		public ResponseEntity<DataResult<List<User>>> getAll()
		{
			return ResponseEntity.ok(userService.getAll());
		}
		@GetMapping("/{userId}")
		public ResponseEntity<DataResult<User>> getById(@PathVariable int userId)
		{
			return ResponseEntity.ok(userService.get(userId)); 
		}

		@PostMapping("/add")
		public ResponseEntity<?> add(@RequestBody User user){
			return ResponseEntity.ok(this.userService.Add(user));
		}
		@DeleteMapping("/delete")
		public ResponseEntity<?> delete(@RequestBody User user){
			return ResponseEntity.ok(this.userService.Delete(user));
		}
		@PutMapping("/update")
		public ResponseEntity<?> update(@RequestBody User user){
			return ResponseEntity.ok(this.userService.Update(user));
		}
		
}
