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

import com.aqsaindia.boqtobom.entities.VendorMaster;
import com.aqsaindia.boqtobom.service.VendorService;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://boqtobom.aqsaindia.com"})
@RequestMapping("/api/v1/vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@PostMapping(path = "insertVendor")
	public ResponseEntity<VendorMaster> insertVendor(@RequestBody VendorMaster vendor) {
		VendorMaster vendor1 = vendorService.insertVendor(vendor);
		ResponseEntity<VendorMaster> responseEntity = new ResponseEntity<VendorMaster>(vendor1,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "findVendorById/{id}")
	public ResponseEntity<VendorMaster> findVendorById(@PathVariable int id) {
		VendorMaster vendor1 = vendorService.findByVendorId(id);
		ResponseEntity<VendorMaster> responseEntity = new ResponseEntity<VendorMaster>(vendor1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findAllVendors")
	public ResponseEntity<List<VendorMaster>> findAllVendors() {
		List<VendorMaster> vendors = vendorService.findAllVendors();
		ResponseEntity<List<VendorMaster>> responseEntity = new ResponseEntity<List<VendorMaster>>(vendors,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(path = "updateVendor")
	public ResponseEntity<VendorMaster> updateVendor(@RequestBody VendorMaster vendor) {
		VendorMaster vendor1 = vendorService.updateVendor(vendor);
		ResponseEntity<VendorMaster> responseEntity = new ResponseEntity<VendorMaster>(vendor1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteVendor")
	public ResponseEntity<VendorMaster> deleteVendor(@RequestBody VendorMaster vendor) {
		VendorMaster vendor1 = vendorService.deleteVendor(vendor);
		ResponseEntity<VendorMaster> responseEntity = new ResponseEntity<VendorMaster>(vendor1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteVendorPermanently")
	public ResponseEntity<VendorMaster> deleteVendorPermanently(@RequestBody VendorMaster vendor) {
		VendorMaster vendor1 = vendorService.deleteVendorPermanently(vendor);
		ResponseEntity<VendorMaster> responseEntity = new ResponseEntity<VendorMaster>(vendor1,HttpStatus.OK);
		return responseEntity;
	}
	
}
