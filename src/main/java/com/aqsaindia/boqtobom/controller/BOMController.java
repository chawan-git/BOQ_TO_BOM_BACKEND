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

import com.aqsaindia.boqtobom.entities.BOMTable;
import com.aqsaindia.boqtobom.service.BOMService;


/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://boqtobom.aqsaindia.com"})
@RequestMapping("/api/v1/bom")
public class BOMController {
	
	@Autowired
	BOMService bomService;
	
	@PostMapping(path = "insertBOM")
	public ResponseEntity<BOMTable> insertBOM(@RequestBody BOMTable bom) {
		BOMTable bom1 = bomService.insertBOM(bom);
		ResponseEntity<BOMTable> responseEntity = new ResponseEntity<BOMTable>(bom1,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "findBOMById/{id}")
	public ResponseEntity<BOMTable> findBOMById(@PathVariable int id) {
		BOMTable bom1 = bomService.findBOMById(id);
		ResponseEntity<BOMTable> responseEntity = new ResponseEntity<BOMTable>(bom1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findBOMByBOMId/{id}")
	public ResponseEntity<BOMTable> findBOMByBOMId(@PathVariable String BOMId) {
		BOMTable bom1 = bomService.findBOMByBOMId(BOMId);
		ResponseEntity<BOMTable> responseEntity = new ResponseEntity<BOMTable>(bom1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findAllBOMs")
	public ResponseEntity<List<BOMTable>> findAllBOMs() {
		List<BOMTable> boms = bomService.findAllBOMs();
		ResponseEntity<List<BOMTable>> responseEntity = new ResponseEntity<List<BOMTable>>(boms,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(path = "updateBOM")
	public ResponseEntity<BOMTable> updateBOM(@RequestBody BOMTable bom) {
		BOMTable bom1 = bomService.updateBOM(bom);
		ResponseEntity<BOMTable> responseEntity = new ResponseEntity<BOMTable>(bom1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteBOM")
	public ResponseEntity<BOMTable> deleteBOM(@RequestBody BOMTable bom) {
		BOMTable bom1 = bomService.deleteBOM(bom);
		ResponseEntity<BOMTable> responseEntity = new ResponseEntity<BOMTable>(bom1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteBOMPermanently")
	public ResponseEntity<BOMTable> deleteBOMPermanently(@RequestBody BOMTable bom) {
		BOMTable bom1 = bomService.deleteBOMPermanently(bom);
		ResponseEntity<BOMTable> responseEntity = new ResponseEntity<BOMTable>(bom1,HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping(path = "boqToBom/{boqId}")
	public ResponseEntity<String> boqToBom(@PathVariable String boqId) {
		String bomId = bomService.boqToBom(boqId);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(bomId,HttpStatus.OK);
		return responseEntity;
	}
}
