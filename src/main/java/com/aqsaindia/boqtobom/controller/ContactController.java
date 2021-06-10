/**
	 * @author Ashutosh Rao Chawan & Suggala Manasvi
	 *
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

import com.aqsaindia.boqtobom.entities.ContactTable;

import com.aqsaindia.boqtobom.service.ContactService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://boqtobom.aqsaindia.com" })
@RequestMapping("/api/v1/contact")
public class ContactController {

	@Autowired
	ContactService contactService;

	@PostMapping(path = "insertContact")
	public ResponseEntity<ContactTable> insertContact(@RequestBody ContactTable contact) {
		ContactTable contact1 = contactService.insertContact(contact);
		ResponseEntity<ContactTable> responseEntity = new ResponseEntity<ContactTable>(contact1, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(path = "findContactById/{id}")
	public ResponseEntity<ContactTable> findContactById(@PathVariable int id) {
		ContactTable contact1 = contactService.findContactById(id);
		ResponseEntity<ContactTable> responseEntity = new ResponseEntity<ContactTable>(contact1, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path = "findAllContacts")
	public ResponseEntity<List<ContactTable>> findAllContacts() {
		List<ContactTable> contacts = contactService.findAllContacts();
		ResponseEntity<List<ContactTable>> responseEntity = new ResponseEntity<List<ContactTable>>(contacts,
				HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping(path = "updateMachine")
	public ResponseEntity<ContactTable> updateContact(@RequestBody ContactTable contact) {
		ContactTable contact1 = contactService.updateContact(contact);
		ResponseEntity<ContactTable> responseEntity = new ResponseEntity<ContactTable>(contact1, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "deleteContact")
	public ResponseEntity<ContactTable> deleteMachine(@RequestBody ContactTable contact) {
		ContactTable contact1 = contactService.deleteContact(contact);
		ResponseEntity<ContactTable> responseEntity = new ResponseEntity<ContactTable>(contact1, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "deleteContactPermanently")
	public ResponseEntity<ContactTable> deleteContactPermanently(@RequestBody ContactTable contact) {
		ContactTable contact1 = contactService.deleteContactPermanently(contact);
		ResponseEntity<ContactTable> responseEntity = new ResponseEntity<ContactTable>(contact1, HttpStatus.OK);
		return responseEntity;
	}

}
