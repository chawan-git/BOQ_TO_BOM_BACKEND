/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aqsaindia.boqtobom.entities.UserMaster;
import com.aqsaindia.boqtobom.service.UserService;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://boqtobom.aqsaindia.com"})
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "insertUser")
	public ResponseEntity<UserMaster> insertUser(@RequestBody UserMaster user) {
		UserMaster user1 = userService.insertUser(user);
		ResponseEntity<UserMaster> responseEntity = new ResponseEntity<UserMaster>(user1,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "findUserById/{id}")
	public ResponseEntity<UserMaster> findUserById(@PathVariable int id) {
		UserMaster user1 = userService.findUserById(id);
		ResponseEntity<UserMaster> responseEntity = new ResponseEntity<UserMaster>(user1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findAllUsers")
	public ResponseEntity<List<UserMaster>> findAllUsers() {
		List<UserMaster> users = userService.findAllUsers();
		ResponseEntity<List<UserMaster>> responseEntity = new ResponseEntity<List<UserMaster>>(users,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(path = "updateUser")
	public ResponseEntity<UserMaster> updateUser(@RequestBody UserMaster user) {
		UserMaster user1 = userService.updateUser(user);
		ResponseEntity<UserMaster> responseEntity = new ResponseEntity<UserMaster>(user1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteUser")
	public ResponseEntity<UserMaster> deleteUser(@RequestBody UserMaster user) {
		UserMaster user1 = userService.deleteUser(user);
		ResponseEntity<UserMaster> responseEntity = new ResponseEntity<UserMaster>(user1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteUserPermanently")
	public ResponseEntity<UserMaster> deleteUserPermanently(@RequestBody UserMaster user) {
		UserMaster user1 = userService.deleteUserPermanently(user);
		ResponseEntity<UserMaster> responseEntity = new ResponseEntity<UserMaster>(user1,HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping(path = "signIn")
	public ResponseEntity<UserMaster> signIn(@RequestBody Map<String,String> userMap) {
		UserMaster user1 = userService.signIn(userMap.get("username"), userMap.get("password"));
		ResponseEntity<UserMaster> responseEntity = new ResponseEntity<UserMaster>(user1,HttpStatus.OK);
		return responseEntity;
	}
}
