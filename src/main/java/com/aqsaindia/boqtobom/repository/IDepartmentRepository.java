
/*
 * @author- Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aqsaindia.boqtobom.entities.DepartmentMaster;

public interface IDepartmentRepository extends JpaRepository<DepartmentMaster, Integer> {

}