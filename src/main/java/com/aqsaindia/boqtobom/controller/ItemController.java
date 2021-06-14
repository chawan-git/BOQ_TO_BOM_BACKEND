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

import com.aqsaindia.boqtobom.entities.ItemMaster;
import com.aqsaindia.boqtobom.service.ItemService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://boqtobom.aqsaindia.com" })
@RequestMapping("/api/v1/item")
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping(path = "insertItem")
	public ResponseEntity<ItemMaster> insertItem(@RequestBody ItemMaster item) {
		ItemMaster item1 = itemService.insertItem(item);
		ResponseEntity<ItemMaster> responseEntity = new ResponseEntity<ItemMaster>(item1, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(path = "findItemById/{id}")
	public ResponseEntity<ItemMaster> findItemById(@PathVariable int id) {
		ItemMaster item1 = itemService.findItemById(id);
		ResponseEntity<ItemMaster> responseEntity = new ResponseEntity<ItemMaster>(item1, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path = "findItemByName/{itemName}")
	public ResponseEntity<ItemMaster> findItemById(@PathVariable String itemName) {
		ItemMaster item1 = itemService.findItemByName(itemName);
		ResponseEntity<ItemMaster> responseEntity = new ResponseEntity<ItemMaster>(item1, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(path = "findAllItems")
	public ResponseEntity<List<ItemMaster>> findAllItems() {
		List<ItemMaster> items = itemService.findAllItems();
		ResponseEntity<List<ItemMaster>> responseEntity = new ResponseEntity<List<ItemMaster>>(items, HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping(path = "updateItem")
	public ResponseEntity<ItemMaster> updateItem(@RequestBody ItemMaster item) {
		ItemMaster item1 = itemService.updateItem(item);
		ResponseEntity<ItemMaster> responseEntity = new ResponseEntity<ItemMaster>(item1, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "deleteItem")
	public ResponseEntity<ItemMaster> deleteItem(@RequestBody ItemMaster item) {
		ItemMaster item1 = itemService.deleteItem(item);
		ResponseEntity<ItemMaster> responseEntity = new ResponseEntity<ItemMaster>(item1, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(path = "deleteItemPermanently")
	public ResponseEntity<ItemMaster> deleteItemPermanently(@RequestBody ItemMaster item) {
		ItemMaster item1 = itemService.deleteItemPermanently(item);
		ResponseEntity<ItemMaster> responseEntity = new ResponseEntity<ItemMaster>(item1, HttpStatus.OK);
		return responseEntity;
	}

}