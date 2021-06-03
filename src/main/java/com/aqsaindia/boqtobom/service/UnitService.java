/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.UnitMaster;
import com.aqsaindia.boqtobom.repository.IUnitRepository;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Service
public class UnitService {
	
	@Autowired
	private IUnitRepository unitRepository;
	
	public UnitMaster insertUnit(UnitMaster unit) {
		return unitRepository.save(unit);
	}
	
	public UnitMaster findUnitById(int id) {
		return unitRepository.findById(id).get();
	}
	
	public UnitMaster findUnitByName(String unitName) {
		return unitRepository.findByUnitName(unitName);
	}
	
	public List<UnitMaster> findAllUnits() {
		return unitRepository.findAll();
	}
	
	public UnitMaster updateUnit(UnitMaster unit) {
		UnitMaster unit1 = unitRepository.findById(unit.getId()).get();
		unit1.setId(unit.getId());
		unit1.setUnitName(unit.getUnitName());
		unit1.setDel(unit.getDel());
		return unitRepository.save(unit1);
	}
	
	public UnitMaster deleteUnit(UnitMaster unit) {
		UnitMaster unit1 = unitRepository.findById(unit.getId()).get();
		unit1.setId(unit.getId());
		unit1.setUnitName(unit.getUnitName());
		unit1.setDel(1);
		return unitRepository.save(unit1);
	}
	
	public UnitMaster deleteUnitPermanently(UnitMaster unit) {
		unitRepository.delete(unit);
		return unit;
	}

}
