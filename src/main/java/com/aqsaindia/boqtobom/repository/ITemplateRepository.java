/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aqsaindia.boqtobom.entities.TemplateTable;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Repository
public interface ITemplateRepository extends JpaRepository<TemplateTable, Integer>{

}
