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

import com.aqsaindia.boqtobom.entities.UnitMaster;
import com.aqsaindia.boqtobom.service.UnitService;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://boqtobom.aqsaindia.com"})
@RequestMapping("/api/v1/unit")
public class UnitController {
	
	@Autowired
	UnitService unitService;
	
	@PostMapping(path = "insertUnit")
	public ResponseEntity<UnitMaster> insertUnit(@RequestBody UnitMaster unit) {
		UnitMaster unit1 = unitService.insertUnit(unit);
		ResponseEntity<UnitMaster> responseEntity = new ResponseEntity<UnitMaster>(unit1,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "findUnitById/{id}")
	public ResponseEntity<UnitMaster> findUnitById(@PathVariable int id) {
		UnitMaster unit1 = unitService.findUnitById(id);
		ResponseEntity<UnitMaster> responseEntity = new ResponseEntity<UnitMaster>(unit1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findUnitByName/{name}")
	public ResponseEntity<UnitMaster> findUnitById(@PathVariable String name) {
		UnitMaster unit1 = unitService.findUnitByName(name);
		ResponseEntity<UnitMaster> responseEntity = new ResponseEntity<UnitMaster>(unit1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findAllUnits")
	public ResponseEntity<List<UnitMaster>> findAllUnits() {
		List<UnitMaster> units = unitService.findAllUnits();
		ResponseEntity<List<UnitMaster>> responseEntity = new ResponseEntity<List<UnitMaster>>(units,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(path = "updateUnit")
	public ResponseEntity<UnitMaster> updateUnit(@RequestBody UnitMaster unit) {
		UnitMaster unit1 = unitService.updateUnit(unit);
		ResponseEntity<UnitMaster> responseEntity = new ResponseEntity<UnitMaster>(unit1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteUnit")
	public ResponseEntity<UnitMaster> deleteUnit(@RequestBody UnitMaster unit) {
		UnitMaster unit1 = unitService.deleteUnit(unit);
		ResponseEntity<UnitMaster> responseEntity = new ResponseEntity<UnitMaster>(unit1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteUnitPermanently")
	public ResponseEntity<UnitMaster> deleteUnitPermanently(@RequestBody UnitMaster unit) {
		UnitMaster unit1 = unitService.deleteUnitPermanently(unit);
		ResponseEntity<UnitMaster> responseEntity = new ResponseEntity<UnitMaster>(unit1,HttpStatus.OK);
		return responseEntity;
	}
	
}
