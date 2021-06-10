/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.BOMTable;
import com.aqsaindia.boqtobom.entities.BOQTable;
import com.aqsaindia.boqtobom.entities.TemplateTable;
import com.aqsaindia.boqtobom.repository.IBOMRepository;
import com.aqsaindia.boqtobom.repository.IBOQRepository;
import com.aqsaindia.boqtobom.repository.ITemplateRepository;

@Service
public class BOMService {

	@Autowired
	private IBOMRepository bomRepository;
	
	@Autowired
	private IBOQRepository boqRepository;
	
	@Autowired
	private ITemplateRepository templateRepository;

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
	
	public String boqToBom(String boqId) {
		int flag = 0;
		List<BOQTable> boqResult = boqRepository.findByBOQId(boqId);
		for(int i=0; i<boqResult.size(); i++) {
			List<TemplateTable> templateResult = templateRepository.findTemplateByBOQ(boqResult.get(i).getMachine(),boqResult.get(i).getWork(),boqResult.get(i).getSubWork());
			for(int j=0; j<templateResult.size(); j++) {
				BOMTable bom = new BOMTable();
				bom.setBOMId("BOM - "+boqId);
				bom.setBOQ(boqResult.get(i));
				bom.setMachine(templateResult.get(j).getMachine());
				bom.setWork(templateResult.get(j).getWork());
				bom.setSubWork(templateResult.get(j).getSubWork());
				bom.setItem(templateResult.get(j).getItem());
				bom.setQty(boqResult.get(i).getQty() * templateResult.get(j).getQty());
				bom.setUnit(templateResult.get(j).getUnit());
				bom.setRate(templateResult.get(j).getCostPrice());
				bom.setAmount(boqResult.get(i).getQty() * templateResult.get(j).getQty() * templateResult.get(j).getCostPrice());
				bom.setDel(0);
				if(bomRepository.save(bom) != null) {
					flag = 0;
				}
				else {
					flag = 1;
					break;
				}
				
			}
		}
		
		if(flag == 1) {
			return "false";
		}
		else {
			return "BOM - "+boqId;
		}
	}

}