/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.VendorMaster;
import com.aqsaindia.boqtobom.repository.IVendorRepository;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Service
public class VendorService {

	@Autowired
	private IVendorRepository vendorRepository;
	
	public VendorMaster insertVendor(VendorMaster vendor) {
		return vendorRepository.save(vendor);
	}
	
	public VendorMaster findByVendorId(int id) {
		return vendorRepository.findById(id).get();
	}
	
	public List<VendorMaster> findAllVendors() {
		return vendorRepository.findAll();
	}
	
	public VendorMaster updateVendor(VendorMaster vendor) {
		VendorMaster vendor1 = vendorRepository.findById(vendor.getId()).get();
		vendor1.setId(vendor.getId());
		vendor1.setVendorName(vendor.getVendorName());
		vendor1.setGst(vendor.getGst());
		vendor1.setContact(vendor.getContact());
		vendor1.setDel(vendor.getDel());
		return vendorRepository.save(vendor1);
	}
	
	public VendorMaster deleteVendor(VendorMaster vendor) {
		VendorMaster vendor1 = vendorRepository.findById(vendor.getId()).get();
		vendor1.setId(vendor.getId());
		vendor1.setVendorName(vendor.getVendorName());
		vendor1.setGst(vendor.getGst());
		vendor1.setContact(vendor.getContact());
		vendor1.setDel(1);
		return vendorRepository.save(vendor1);
	}
	
	public VendorMaster deleteVendorPermanently(VendorMaster vendor) {
		vendorRepository.delete(vendor);
		return vendor;
	}

}
