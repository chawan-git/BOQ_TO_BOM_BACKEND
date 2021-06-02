/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.MachineMaster;
import com.aqsaindia.boqtobom.repository.IMachineRepository;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Service
public class MachineService {
	
	@Autowired
	private IMachineRepository machineRepository;
	
	public MachineMaster insertMachine(MachineMaster machine) {
		return machineRepository.save(machine);
	}
	
	public MachineMaster findById(int id) {
		return machineRepository.findById(id).get();
	}
	
	public MachineMaster findByMachineName(String machineName) {
		return machineRepository.findByMachineName(machineName);
	}
	
	public List<MachineMaster> findAllMachines() {
		return machineRepository.findAll();
	}
	
	public MachineMaster updateMachine(MachineMaster machine) {
		MachineMaster machine1 = machineRepository.findById(machine.getId()).get();
		machine1.setId(machine.getId());
		machine1.setMachineName(machine.getMachineName());
		machine1.setDel(machine.getDel());
		return machineRepository.save(machine1);
	}
	
	public MachineMaster deleteMachine(MachineMaster machine) {
		MachineMaster machine1 = machineRepository.findById(machine.getId()).get();
		machine1.setId(machine.getId());
		machine1.setMachineName(machine.getMachineName());
		machine1.setDel(1);
		return machineRepository.save(machine1);
	}
	
	public MachineMaster deleteMachinePermanently(MachineMaster machine) {
		machineRepository.delete(machine);
		return machine;
	}

}
