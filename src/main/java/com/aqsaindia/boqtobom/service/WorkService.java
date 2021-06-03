package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.WorkMaster;
import com.aqsaindia.boqtobom.repository.IWorkRepository;

@Service
public class WorkService {

	@Autowired
	private IWorkRepository workRepository;

	public WorkMaster insertWork(WorkMaster work) {
		return workRepository.save(work);
	}

	public WorkMaster findWorkById(int id) {
		return workRepository.findById(id).get();
	}

	public WorkMaster findWorkByName(String workName) {
		return workRepository.findByWorkName(workName);
	}

	public List<WorkMaster> findAllWork() {
		return workRepository.findAll();
	}

	public WorkMaster updateWork(WorkMaster work) {
		WorkMaster work1 = workRepository.findById(work.getId()).get();
		work1.setId(work.getId());
		work1.setWorkName(work.getWorkName());
		work1.setDel(work.getDel());
		return workRepository.save(work1);
	}

	public WorkMaster deleteWork(WorkMaster work) {
		WorkMaster work1 = workRepository.findById(work.getId()).get();
		work1.setId(work.getId());
		work1.setWorkName(work.getWorkName());
		work1.setDel(1);
		return workRepository.save(work1);
	}

	public WorkMaster deleteWorkPermanently(WorkMaster work) {
		workRepository.delete(work);
		return work;

	}
}
