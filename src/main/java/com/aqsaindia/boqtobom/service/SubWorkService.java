/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi 
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aqsaindia.boqtobom.entities.SubWorkMaster;
import com.aqsaindia.boqtobom.repository.ISubWorkRepository;

@Service
public class SubWorkService {

	@Autowired
	private ISubWorkRepository subWorkRepository;

	public SubWorkMaster insertSubWork(SubWorkMaster subWork) {
		return subWorkRepository.save(subWork);
	}

	public SubWorkMaster findSubWorkById(int id) {
		return subWorkRepository.findById(id).get();
	}

	public SubWorkMaster findSubWorkByName(String subWorkName) {
		return subWorkRepository.findBySubWorkName(subWorkName);
	}

	public List<SubWorkMaster> findAllSubWork() {
		return subWorkRepository.findAll();
	}

	public SubWorkMaster updateSubWork(SubWorkMaster subWork) {
		SubWorkMaster subWork1 = subWorkRepository.findById(subWork.getId()).get();
		subWork1.setId(subWork.getId());
		subWork1.setSubWorkName(subWork.getSubWorkName());
		subWork1.setDel(subWork.getDel());
		return subWorkRepository.save(subWork1);
	}

	public SubWorkMaster deleteSubWork(SubWorkMaster subWork) {
		SubWorkMaster subWork1 = subWorkRepository.findById(subWork.getId()).get();
		subWork1.setId(subWork.getId());
		subWork1.setSubWorkName(subWork.getSubWorkName());
		subWork1.setDel(1);
		return subWorkRepository.save(subWork1);
	}

	public SubWorkMaster deleteSubWorkPermanently(SubWorkMaster subWork) {
		subWorkRepository.delete(subWork);
		return subWork;

	}
}
