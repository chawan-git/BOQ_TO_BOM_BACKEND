/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aqsaindia.boqtobom.entities.MachineMaster;
import com.aqsaindia.boqtobom.entities.SubWorkMaster;
import com.aqsaindia.boqtobom.entities.TemplateTable;
import com.aqsaindia.boqtobom.entities.WorkMaster;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Repository
public interface ITemplateRepository extends JpaRepository<TemplateTable, Integer>{

	@Query("SELECT template FROM TemplateTable template WHERE template.machine = ?1 AND template.work = ?2 AND template.subWork = ?3")
	public List<TemplateTable> findTemplateByBOQ(MachineMaster machine, WorkMaster work, SubWorkMaster subwork);
}
