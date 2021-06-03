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

import com.aqsaindia.boqtobom.entities.SubWorkMaster;
import com.aqsaindia.boqtobom.service.SubWorkService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://boqtobom.aqsaindia.com" })
@RequestMapping("/api/v1/subWork")

public class SubWorkController {

	@Autowired
	SubWorkService subworkService;

	@PostMapping(path = "insertSubWork")
	public ResponseEntity<SubWorkMaster> insertSubWork(@RequestBody SubWorkMaster subwork) {
		SubWorkMaster subwork1 = subworkService.insertSubWork(subwork);
		ResponseEntity<SubWorkMaster> responseEntity = new ResponseEntity<SubWorkMaster>(subwork1, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(path = "findSubWorkById/{id}")
	public ResponseEntity<SubWorkMaster> findSubWorkById(@PathVariable int id) {
		SubWorkMaster subwork1 = subworkService.findSubWorkById(id);
		ResponseEntity<SubWorkMaster> responseEntity = new ResponseEntity<SubWorkMaster>(subwork1, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path = "findSubWorkByName/{id}")
	public ResponseEntity<SubWorkMaster> findSubWorkById(@PathVariable String name) {
		SubWorkMaster subwork1 = subworkService.findSubWorkByName(name);
		ResponseEntity<SubWorkMaster> responseEntity = new ResponseEntity<SubWorkMaster>(subwork1, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path = "findAllSubWork")
	public ResponseEntity<List<SubWorkMaster>> findAllSubWork() {
		List<SubWorkMaster> subwork = subworkService.findAllSubWork();
		ResponseEntity<List<SubWorkMaster>> responseEntity = new ResponseEntity<List<SubWorkMaster>>(subwork,
				HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping(path = "updateSubWork")
	public ResponseEntity<SubWorkMaster> updateSubWork(@RequestBody SubWorkMaster subwork) {
		SubWorkMaster subwork1 = subworkService.updateSubWork(subwork);
		ResponseEntity<SubWorkMaster> responseEntity = new ResponseEntity<SubWorkMaster>(subwork1, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "deleteSubWork")
	public ResponseEntity<SubWorkMaster> deleteSubWork(@RequestBody SubWorkMaster subwork) {
		SubWorkMaster subwork1 = subworkService.deleteSubWork(subwork);
		ResponseEntity<SubWorkMaster> responseEntity = new ResponseEntity<SubWorkMaster>(subwork1, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "deleteSubWorkPermanently")
	public ResponseEntity<SubWorkMaster> deleteSubWorkPermanently(@RequestBody SubWorkMaster subwork) {
		SubWorkMaster subwork1 = subworkService.deleteSubWorkPermanently(subwork);
		ResponseEntity<SubWorkMaster> responseEntity = new ResponseEntity<SubWorkMaster>(subwork1, HttpStatus.OK);
		return responseEntity;
	}

}
