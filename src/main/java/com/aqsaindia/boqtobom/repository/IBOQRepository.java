/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aqsaindia.boqtobom.entities.BOQTable;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Repository
public interface IBOQRepository extends JpaRepository<BOQTable, Integer> {

	@Query("SELECT boq FROM BOQTable boq WHERE boq.BOQID = boqId")
	public BOQTable findByBOQId(String boqId);

}
