/**
 * 
 */
package com.aqsaindia.boqtobom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aqsaindia.boqtobom.entities.MachineMaster;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Repository
public interface IMachineRepository extends JpaRepository<MachineMaster, Integer>{

	@Query("SELECT machines from MachineMaster machines WHERE machines.machineName = ?1")
	public MachineMaster findByMachineName(String machineName);

}