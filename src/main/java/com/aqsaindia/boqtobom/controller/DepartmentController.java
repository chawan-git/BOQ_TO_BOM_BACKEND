/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aqsaindia.boqtobom.entities.DepartmentMaster;
import com.aqsaindia.boqtobom.service.DepartmentService;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://boqtobom.aqsaindia.com"})
@RequestMapping("/api/v1/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping(path = "insertDepartment")
	public ResponseEntity<DepartmentMaster> insertDepartment(@RequestBody DepartmentMaster department) {
		DepartmentMaster department1 = departmentService.insertDepartment(department);
		ResponseEntity<DepartmentMaster> responseEntity = new ResponseEntity<DepartmentMaster>(department1,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "findDepartmentById/{id}")
	public ResponseEntity<DepartmentMaster> findDepartmentById(@PathVariable int id) {
		DepartmentMaster department1 = departmentService.findDepartmentById(id);
		ResponseEntity<DepartmentMaster> responseEntity = new ResponseEntity<DepartmentMaster>(department1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findAllDepartments")
	public ResponseEntity<List<DepartmentMaster>> findAllDepartments() {
		List<DepartmentMaster> departments = departmentService.findAllDepartments();
		ResponseEntity<List<DepartmentMaster>> responseEntity = new ResponseEntity<List<DepartmentMaster>>(departments,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(path = "updateDepartment")
	public ResponseEntity<DepartmentMaster> updateDepartment(@RequestBody DepartmentMaster department) {
		DepartmentMaster department1 = departmentService.updateDepartment(department);
		ResponseEntity<DepartmentMaster> responseEntity = new ResponseEntity<DepartmentMaster>(department1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteDepartment")
	public ResponseEntity<DepartmentMaster> deleteDepartment(@RequestBody DepartmentMaster department) {
		DepartmentMaster department1 = departmentService.deleteDepartment(department);
		ResponseEntity<DepartmentMaster> responseEntity = new ResponseEntity<DepartmentMaster>(department1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteDepartmentPermanently")
	public ResponseEntity<DepartmentMaster> deleteDepartmentPermanently(@RequestBody DepartmentMaster department) {
		DepartmentMaster department1 = departmentService.deleteDepartmentPermanently(department);
		ResponseEntity<DepartmentMaster> responseEntity = new ResponseEntity<DepartmentMaster>(department1,HttpStatus.OK);
		return responseEntity;
	}
}
