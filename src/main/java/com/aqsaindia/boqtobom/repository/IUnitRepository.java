/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aqsaindia.boqtobom.entities.UnitMaster;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Repository
public interface IUnitRepository extends JpaRepository<UnitMaster, Integer>{
	
	@Query("SELECT units FROM UnitMaster units WHERE units.unitName = ?1")
	public UnitMaster findByUnitName(String unitName);

}
