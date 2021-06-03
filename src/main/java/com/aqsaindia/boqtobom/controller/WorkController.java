/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi 
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

import com.aqsaindia.boqtobom.entities.WorkMaster;

import com.aqsaindia.boqtobom.service.WorkService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://boqtobom.aqsaindia.com" })
@RequestMapping("/api/v1/work")

public class WorkController {

	@Autowired
	WorkService workService;

	@PostMapping(path = "insertWork")
	public ResponseEntity<WorkMaster> insertWork(@RequestBody WorkMaster work) {
		WorkMaster work1 = workService.insertWork(work);
		ResponseEntity<WorkMaster> responseEntity = new ResponseEntity<WorkMaster>(work1, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(path = "findWorkById/{id}")
	public ResponseEntity<WorkMaster> findWorkById(@PathVariable int id) {
		WorkMaster work1 = workService.findWorkById(id);
		ResponseEntity<WorkMaster> responseEntity = new ResponseEntity<WorkMaster>(work1, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path = "findWorkByName/{id}")
	public ResponseEntity<WorkMaster> findWorkById(@PathVariable String name) {
		WorkMaster work1 = workService.findWorkByName(name);
		ResponseEntity<WorkMaster> responseEntity = new ResponseEntity<WorkMaster>(work1, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path = "findAllWork")
	public ResponseEntity<List<WorkMaster>> findAllWork() {
		List<WorkMaster> work = workService.findAllWork();
		ResponseEntity<List<WorkMaster>> responseEntity = new ResponseEntity<List<WorkMaster>>(work, HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping(path = "updateWork")
	public ResponseEntity<WorkMaster> updateWork(@RequestBody WorkMaster work) {
		WorkMaster work1 = workService.updateWork(work);
		ResponseEntity<WorkMaster> responseEntity = new ResponseEntity<WorkMaster>(work1, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "deleteWork")
	public ResponseEntity<WorkMaster> deleteWork(@RequestBody WorkMaster work) {
		WorkMaster work1 = workService.deleteWork(work);
		ResponseEntity<WorkMaster> responseEntity = new ResponseEntity<WorkMaster>(work1, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "deleteWorkPermanently")
	public ResponseEntity<WorkMaster> deleteWorkPermanently(@RequestBody WorkMaster work) {
		WorkMaster work1 = workService.deleteWorkPermanently(work);
		ResponseEntity<WorkMaster> responseEntity = new ResponseEntity<WorkMaster>(work1, HttpStatus.OK);
		return responseEntity;
	}

}
