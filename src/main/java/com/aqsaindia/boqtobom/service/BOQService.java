/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.BOQTable;
import com.aqsaindia.boqtobom.repository.IBOQRepository;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Service
public class BOQService {
	
	@Autowired
	private IBOQRepository boqRepository;
	
	public BOQTable insertBOQ(BOQTable boq) {
		return boqRepository.save(boq);
	}
	
	public BOQTable findBOQById(int id) {
		return boqRepository.findById(id).get();
	}
	
	public BOQTable findBOQByBOQId(String BOQId) {
		return boqRepository.findByBOQId(BOQId);
	}
	
	public List<BOQTable> findAllBOQs() {
		return boqRepository.findAll();
	}
	
	public BOQTable updateBOQ(BOQTable boq) {
		BOQTable boq1 = boqRepository.findById(boq.getId()).get();
		boq1.setId(boq.getId());
		boq1.setBOQId(boq.getBOQId());
		boq1.setMachine(boq.getMachine());
		boq1.setDescription(boq.getDescription());
		boq1.setWork(boq.getWork());
		boq1.setSubWork(boq.getSubWork());
		boq1.setQty(boq.getQty());
		boq1.setUnit(boq.getUnit());
		boq1.setRate(boq.getRate());
		boq1.setAmount(boq.getAmount());
		boq1.setDel(boq.getDel());
		return boqRepository.save(boq1);
	}
	
	public BOQTable deleteBOQ(BOQTable boq) {
		BOQTable boq1 = boqRepository.findById(boq.getId()).get();
		boq1.setId(boq.getId());
		boq1.setBOQId(boq.getBOQId());
		boq1.setMachine(boq.getMachine());
		boq1.setDescription(boq.getDescription());
		boq1.setWork(boq.getWork());
		boq1.setSubWork(boq.getSubWork());
		boq1.setQty(boq.getQty());
		boq1.setUnit(boq.getUnit());
		boq1.setRate(boq.getRate());
		boq1.setAmount(boq.getAmount());
		boq1.setDel(1);
		return boqRepository.save(boq1);
	}
	
	public BOQTable deleteBOQPermanently(BOQTable boq) {
		boqRepository.delete(boq);
		return boq;
	}

}
