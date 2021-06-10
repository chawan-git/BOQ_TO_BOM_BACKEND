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

import com.aqsaindia.boqtobom.entities.MachineMaster;
import com.aqsaindia.boqtobom.entities.SubWorkMaster;
import com.aqsaindia.boqtobom.entities.TemplateTable;
import com.aqsaindia.boqtobom.entities.WorkMaster;
import com.aqsaindia.boqtobom.service.TemplateService;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://boqtobom.aqsaindia.com"})
@RequestMapping("/api/v1/template")
public class TemplateController {
	
	@Autowired
	TemplateService templateService;
	
	@PostMapping(path = "insertTemplate")
	public ResponseEntity<TemplateTable> insertTemplate(@RequestBody TemplateTable template) {
		TemplateTable template1 = templateService.insertTemplate(template);
		ResponseEntity<TemplateTable> responseEntity = new ResponseEntity<TemplateTable>(template1,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "findTemplateById/{id}")
	public ResponseEntity<TemplateTable> findTemplateById(@PathVariable int id) {
		TemplateTable template1 = templateService.findTemplateById(id);
		ResponseEntity<TemplateTable> responseEntity = new ResponseEntity<TemplateTable>(template1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findAllTemplates")
	public ResponseEntity<List<TemplateTable>> findAllTemplates() {
		List<TemplateTable> templates = templateService.findAllTemplates();
		ResponseEntity<List<TemplateTable>> responseEntity = new ResponseEntity<List<TemplateTable>>(templates,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(path = "updateTemplate")
	public ResponseEntity<TemplateTable> updateTemplate(@RequestBody TemplateTable template) {
		TemplateTable template1 = templateService.updateTemplate(template);
		ResponseEntity<TemplateTable> responseEntity = new ResponseEntity<TemplateTable>(template1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteTemplate")
	public ResponseEntity<TemplateTable> deleteTemplate(@RequestBody TemplateTable template) {
		TemplateTable template1 = templateService.deleteTemplate(template);
		ResponseEntity<TemplateTable> responseEntity = new ResponseEntity<TemplateTable>(template1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteTemplatePermanently")
	public ResponseEntity<TemplateTable> deleteTemplatePermanently(@RequestBody TemplateTable template) {
		TemplateTable template1 = templateService.deleteTemplatePermanently(template);
		ResponseEntity<TemplateTable> responseEntity = new ResponseEntity<TemplateTable>(template1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findTemplateByBOQ")
	public ResponseEntity<List<TemplateTable>> findTemplateByBOQ(@RequestBody MachineMaster machine, @RequestBody WorkMaster work, @RequestBody SubWorkMaster subwork) {
		List<TemplateTable> templates = templateService.findTemplateByBOQ(machine, work, subwork);
		ResponseEntity<List<TemplateTable>> responseEntity = new ResponseEntity<List<TemplateTable>>(templates,HttpStatus.OK);
		return responseEntity;
	}
}
