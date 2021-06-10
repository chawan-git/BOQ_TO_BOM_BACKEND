/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.repository;

import java.util.List;

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

	@Query("SELECT BOQ FROM BOQTable BOQ WHERE BOQ.BOQId = ?1")
	public List<BOQTable> findByBOQId(String BOQId);

}
