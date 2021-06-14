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

import com.aqsaindia.boqtobom.entities.BOQTable;
import com.aqsaindia.boqtobom.service.BOQService;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://boqtobom.aqsaindia.com"})
@RequestMapping("/api/v1/boq")
public class BOQController {
	
	@Autowired
	BOQService boqService;
	
	@PostMapping(path = "insertBOQ")
	public ResponseEntity<BOQTable> insertBOQ(@RequestBody BOQTable boq) {
		BOQTable boq1 = boqService.insertBOQ(boq);
		ResponseEntity<BOQTable> responseEntity = new ResponseEntity<BOQTable>(boq1,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "findBOQById/{id}")
	public ResponseEntity<BOQTable> findBOQById(@PathVariable int id) {
		BOQTable boq1 = boqService.findBOQById(id);
		ResponseEntity<BOQTable> responseEntity = new ResponseEntity<BOQTable>(boq1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findBOQByBOQId/{BOQId}")
	public ResponseEntity<List<BOQTable>> findBOQByBOQId(@PathVariable String BOQId) {
		List<BOQTable> boq1 = boqService.findBOQByBOQId(BOQId);
		ResponseEntity<List<BOQTable>> responseEntity = new ResponseEntity<List<BOQTable>>(boq1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findAllBOQs")
	public ResponseEntity<List<BOQTable>> findAllBOQs() {
		List<BOQTable> boqs = boqService.findAllBOQs();
		ResponseEntity<List<BOQTable>> responseEntity = new ResponseEntity<List<BOQTable>>(boqs,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(path = "updateBOQ")
	public ResponseEntity<BOQTable> updateBOQ(@RequestBody BOQTable boq) {
		BOQTable boq1 = boqService.updateBOQ(boq);
		ResponseEntity<BOQTable> responseEntity = new ResponseEntity<BOQTable>(boq1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteBOQ")
	public ResponseEntity<BOQTable> deleteBOQ(@RequestBody BOQTable boq) {
		BOQTable boq1 = boqService.deleteBOQ(boq);
		ResponseEntity<BOQTable> responseEntity = new ResponseEntity<BOQTable>(boq1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteBOQPermanently")
	public ResponseEntity<BOQTable> deleteBOQPermanently(@RequestBody BOQTable boq) {
		BOQTable boq1 = boqService.deleteBOQPermanently(boq);
		ResponseEntity<BOQTable> responseEntity = new ResponseEntity<BOQTable>(boq1,HttpStatus.OK);
		return responseEntity;
	}
	
}
