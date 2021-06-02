package com.aqsaindia.boqtobom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aqsaindia.boqtobom.entities.WorkMaster;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 * 
 **/

@Repository
public interface IWorkRepository extends JpaRepository<WorkMaster, Integer> {

	@Query("SELECT workmaster FROM  WorkMaster work WHERE work.WorkName = ?1")
	public WorkMaster findByWorkName(String WorkName);

}
