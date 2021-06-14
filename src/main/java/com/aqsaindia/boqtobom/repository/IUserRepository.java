/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aqsaindia.boqtobom.entities.UserMaster;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Repository
public interface IUserRepository extends JpaRepository<UserMaster, Integer>{
	
	@Query("SELECT user FROM UserMaster user WHERE user.username = ?1 AND user.password = ?2")
	public UserMaster signIn(String username, String password);
}
