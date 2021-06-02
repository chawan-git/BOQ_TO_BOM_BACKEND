package com.aqsaindia.boqtobom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aqsaindia.boqtobom.entities.SubWorkMaster;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 * 
 **/

@Repository
public interface ISubWorkRepository extends JpaRepository<SubWorkMaster, Integer> {

	@Query("SELECT subwork FROM  SubWorkMaster subwork WHERE subwork.subWorkName = ?1")
	public SubWorkMaster findBySubWorkName(String subWorkName);

}
