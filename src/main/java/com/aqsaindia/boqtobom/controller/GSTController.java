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

import com.aqsaindia.boqtobom.entities.GSTTable;
import com.aqsaindia.boqtobom.service.GSTService;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://boqtobom.aqsaindia.com"})
@RequestMapping("/api/v1/gst")
public class GSTController {
	
	@Autowired
	private GSTService gstService;
	
	@PostMapping(path = "insertGST")
	public ResponseEntity<GSTTable> insertGST(@RequestBody GSTTable gst) {
		GSTTable gst1 = gstService.insertGST(gst);
		ResponseEntity<GSTTable> responseEntity = new ResponseEntity<GSTTable>(gst1, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "findGSTById/{id}")
	public ResponseEntity<GSTTable> findGSTById(@PathVariable int id) {
		GSTTable gst1 = gstService.findGSTById(id);
		ResponseEntity<GSTTable> responseEntity = new ResponseEntity<GSTTable>(gst1, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findAllGST")
	public ResponseEntity<List<GSTTable>> findAllGST() {
		List<GSTTable> gst1 = gstService.findAllGST();
		ResponseEntity<List<GSTTable>> responseEntity = new ResponseEntity<List<GSTTable>>(gst1, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(path = "updateGST")
	public ResponseEntity<GSTTable> updateGST(@RequestBody GSTTable gst) {
		GSTTable gst1 = gstService.updateGST(gst);
		ResponseEntity<GSTTable> responseEntity = new ResponseEntity<GSTTable>(gst1, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteGST")
	public ResponseEntity<GSTTable> deleteGST(@RequestBody GSTTable gst) {
		GSTTable gst1 = gstService.deleteGST(gst);
		ResponseEntity<GSTTable> responseEntity = new ResponseEntity<GSTTable>(gst1, HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteGSTPermanently")
	public ResponseEntity<GSTTable> deleteGSTPermanently(@RequestBody GSTTable gst) {
		GSTTable gst1 = gstService.deleteGSTPermanently(gst);
		ResponseEntity<GSTTable> responseEntity = new ResponseEntity<GSTTable>(gst1, HttpStatus.OK);
		return responseEntity;
	}
}
