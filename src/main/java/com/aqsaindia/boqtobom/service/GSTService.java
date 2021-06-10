/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.GSTTable;
import com.aqsaindia.boqtobom.repository.IGSTRepository;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Service
public class GSTService {
	
	@Autowired
	private IGSTRepository gstRepository;
	
	public GSTTable insertGST(GSTTable gst) {
		return gstRepository.save(gst);
	}
	
	public GSTTable findGSTById(int id) {
		return gstRepository.findById(id).get();
	}
	
	public List<GSTTable> findAllGST() {
		return gstRepository.findAll();
	}
	
	public GSTTable updateGST(GSTTable gst) {
		GSTTable gst1 = gstRepository.findById(gst.getId()).get();
		gst1.setId(gst.getId());
		gst1.setGstNumber(gst.getGstNumber());
		gst1.setState(gst.getState());
		gst1.setDel(gst.getDel());
		return gstRepository.save(gst1);
	}
	
	public GSTTable deleteGST(GSTTable gst) {
		GSTTable gst1 = gstRepository.findById(gst.getId()).get();
		gst1.setId(gst.getId());
		gst1.setGstNumber(gst.getGstNumber());
		gst1.setState(gst.getState());
		gst1.setDel(1);
		return gstRepository.save(gst1);
	}
	
	public GSTTable deleteGSTPermanently(GSTTable gst) {
		gstRepository.delete(gst);
		return gst;
	}
}
