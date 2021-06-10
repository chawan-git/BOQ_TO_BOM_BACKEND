/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.ContactTable;
import com.aqsaindia.boqtobom.repository.IContactRepository;

@Service
public class ContactService {
	@Autowired
	private IContactRepository contactRepository;

	public ContactTable insertContact(ContactTable contact) {
		return contactRepository.save(contact);
	}

	public ContactTable findContactById(int id) {
		return contactRepository.findById(id).get();
	}

	public List<ContactTable> findAllContacts() {
		return contactRepository.findAll();
	}

	public ContactTable updateContact(ContactTable contact) {
		ContactTable contact1 = contactRepository.findById(contact.getId()).get();
		contact1.setId(contact.getId());
		contact1.setContactName(contact.getContactName());
		contact1.setPhoneNumber(contact.getPhoneNumber());
		contact1.setEmailId(contact.getEmailId());
		contact1.setDepartment(contact.getDepartment());
		contact1.setDel(contact.getDel());
		return contactRepository.save(contact1);
	}

	public ContactTable deleteContact(ContactTable contact) {
		ContactTable contact1 = contactRepository.findById(contact.getId()).get();
		contact1.setId(contact.getId());
		contact1.setContactName(contact.getContactName());
		contact1.setPhoneNumber(contact.getPhoneNumber());
		contact1.setEmailId(contact.getEmailId());
		contact1.setDepartment(contact.getDepartment());
		contact1.setDel(1);
		return contactRepository.save(contact1);
	}

	public ContactTable deleteContactPermanently(ContactTable contact) {
		contactRepository.delete(contact);
		return contact;
	}



}
