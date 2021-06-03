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
import com.aqsaindia.boqtobom.service.MachineService;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://boqtobom.aqsaindia.com"})
@RequestMapping("/api/v1/machine")
public class MachineController {
	
	@Autowired
	MachineService machineService;
	
	@PostMapping(path = "insertMachine")
	public ResponseEntity<MachineMaster> insertMachine(@RequestBody MachineMaster machine) {
		MachineMaster machine1 = machineService.insertMachine(machine);
		ResponseEntity<MachineMaster> responseEntity = new ResponseEntity<MachineMaster>(machine1,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping(path = "findMachineById/{id}")
	public ResponseEntity<MachineMaster> findMachineById(@PathVariable int id) {
		MachineMaster machine1 = machineService.findMachineById(id);
		ResponseEntity<MachineMaster> responseEntity = new ResponseEntity<MachineMaster>(machine1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findMachineByName/{name}")
	public ResponseEntity<MachineMaster> findMachineById(@PathVariable String name) {
		MachineMaster machine1 = machineService.findMachineByName(name);
		ResponseEntity<MachineMaster> responseEntity = new ResponseEntity<MachineMaster>(machine1,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping(path = "findAllMachines")
	public ResponseEntity<List<MachineMaster>> findAllMachines() {
		List<MachineMaster> machines = machineService.findAllMachines();
		ResponseEntity<List<MachineMaster>> responseEntity = new ResponseEntity<List<MachineMaster>>(machines,HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping(path = "updateMachine")
	public ResponseEntity<MachineMaster> updateMachine(@RequestBody MachineMaster machine) {
		MachineMaster machine1 = machineService.updateMachine(machine);
		ResponseEntity<MachineMaster> responseEntity = new ResponseEntity<MachineMaster>(machine1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteMachine")
	public ResponseEntity<MachineMaster> deleteMachine(@RequestBody MachineMaster machine) {
		MachineMaster machine1 = machineService.deleteMachine(machine);
		ResponseEntity<MachineMaster> responseEntity = new ResponseEntity<MachineMaster>(machine1,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping(path = "deleteMachinePermanently")
	public ResponseEntity<MachineMaster> deleteMachinePermanently(@RequestBody MachineMaster machine) {
		MachineMaster machine1 = machineService.deleteMachinePermanently(machine);
		ResponseEntity<MachineMaster> responseEntity = new ResponseEntity<MachineMaster>(machine1,HttpStatus.OK);
		return responseEntity;
	}
	
}
