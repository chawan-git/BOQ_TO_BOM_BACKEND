/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.UserMaster;
import com.aqsaindia.boqtobom.repository.IUserRepository;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Service
public class UserService {

	@Autowired
	private IUserRepository userRepository;
	
	public UserMaster insertUser(UserMaster user) {
		return userRepository.save(user);
	}
	
	public UserMaster findUserById(int id) {
		return userRepository.findById(id).get();
	}
	
	public List<UserMaster> findAllUsers() {
		return userRepository.findAll();
	}
	
	public UserMaster updateUser(UserMaster user) {
		UserMaster user1 = new UserMaster();
		user1.setId(user.getId());
		user1.setEmployee_id(user.getEmployee_id());
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		user1.setEmailId(user.getEmailId());
		user1.setType(user.getType());
		user1.setDel(user.getDel());
		return userRepository.save(user1);
	}
	
	public UserMaster deleteUser(UserMaster user) {
		UserMaster user1 = new UserMaster();
		user1.setId(user.getId());
		user1.setEmployee_id(user.getEmployee_id());
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		user1.setEmailId(user.getEmailId());
		user1.setType(user.getType());
		user1.setDel(1);
		return userRepository.save(user1);
	}
	
	public UserMaster deleteUserPermanently(UserMaster user) {
		userRepository.delete(user);
		return user;
	}
	
	public UserMaster signIn(String username, String password) {
		return userRepository.signIn(username, password);
	}
}
