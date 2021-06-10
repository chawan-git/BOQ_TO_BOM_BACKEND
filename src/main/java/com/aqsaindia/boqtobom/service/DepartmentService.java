/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.DepartmentMaster;

import com.aqsaindia.boqtobom.repository.IDepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private IDepartmentRepository departmentRepository;

	public DepartmentMaster insertDepartment(DepartmentMaster department) {
		return departmentRepository.save(department);
	}

	public DepartmentMaster findDepartmentById(int id) {
		return departmentRepository.findById(id).get();
	}

	public List<DepartmentMaster> findAllDepartments() {
		return departmentRepository.findAll();
	}

	public DepartmentMaster updateDepartment(DepartmentMaster department) {
		DepartmentMaster department1 = departmentRepository.findById(department.getId()).get();
		department1.setId(department.getId());
		department1.setDepartmentName(department.getDepartmentName());
		department1.setDel(department.getDel());
		return departmentRepository.save(department1);
	}

	public DepartmentMaster deleteDepartment(DepartmentMaster department) {
		DepartmentMaster department1 = departmentRepository.findById(department.getId()).get();
		department1.setId(department.getId());
		department1.setDepartmentName(department.getDepartmentName());
		department1.setDel(1);
		return departmentRepository.save(department1);
	}

	public DepartmentMaster deleteDepartmentPermanently(DepartmentMaster department) {
		departmentRepository.delete(department);
		return department;
	}

}
