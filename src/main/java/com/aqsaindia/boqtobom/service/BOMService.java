/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.BOMTable;
import com.aqsaindia.boqtobom.repository.IBOMRepository;

@Service
public class BOMService {

	@Autowired
	private IBOMRepository bomRepository;

	public BOMTable insertBOM(BOMTable bom) {
		return bomRepository.save(bom);
	}

	public BOMTable findBOMById(int id) {
		return bomRepository.findById(id).get();
	}

	public BOMTable findBOMByBOMId(String BOMId) {
		return bomRepository.findByBOMId(BOMId);
	}

	public List<BOMTable> findAllBOMs() {
		return bomRepository.findAll();
	}

	public BOMTable updateBOM(BOMTable bom) {
		BOMTable bom1 = bomRepository.findById(bom.getId()).get();
		bom1.setId(bom.getId());
		bom1.setBOMId(bom.getBOMId());
		bom1.setMachine(bom.getMachine());
		bom1.setWork(bom.getWork());
		bom1.setSubWork(bom.getSubWork());
		bom1.setQty(bom.getQty());
		bom1.setUnit(bom.getUnit());
		bom1.setRate(bom.getRate());
		bom1.setAmount(bom.getAmount());
		bom1.setDel(bom.getDel());
		return bomRepository.save(bom1);
	}

	public BOMTable deleteBOM(BOMTable bom) {
		BOMTable bom1 = bomRepository.findById(bom.getId()).get();
		bom1.setId(bom.getId());
		bom1.setBOMId(bom.getBOMId());
		bom1.setMachine(bom.getMachine());
		bom1.setWork(bom.getWork());
		bom1.setSubWork(bom.getSubWork());
		bom1.setQty(bom.getQty());
		bom1.setUnit(bom.getUnit());
		bom1.setRate(bom.getRate());
		bom1.setAmount(bom.getAmount());
		bom1.setDel(1);
		return bomRepository.save(bom1);
	}

	public BOMTable deleteBOMPermanently(BOMTable bom) {
		bomRepository.delete(bom);
		return bom;
	}

}