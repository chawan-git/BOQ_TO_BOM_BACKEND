/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.TemplateTable;
import com.aqsaindia.boqtobom.repository.ITemplateRepository;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Service
public class TemplateService {

	@Autowired
	private ITemplateRepository templateRepository;
	
	public TemplateTable insertTable(TemplateTable template) {
		return templateRepository.save(template);
	}
	
	public TemplateTable findTemplateById(int id) {
		return templateRepository.findById(id).get();
	}
	
	public List<TemplateTable> findAllTemplates() {
		return templateRepository.findAll();
	}
	
	public TemplateTable updateTemplate(TemplateTable template) {
		TemplateTable template1 = templateRepository.findById(template.getId()).get();
		template1.setId(template.getId());
		template1.setMachine(template.getMachine());
		template1.setWork(template.getWork());
		template1.setSubWork(template.getSubWork());
		template1.setItem(template.getItem());
		template1.setQty(template.getQty());
		template1.setUnit(template.getUnit());
		template1.setCostPrice(template.getCostPrice());
		template1.setAmount(template.getAmount());
		template1.setDel(template.getDel());
		return templateRepository.save(template1);
	}
	
	public TemplateTable deleteTemplate(TemplateTable template) {
		TemplateTable template1 = templateRepository.findById(template.getId()).get();
		template1.setId(template.getId());
		template1.setMachine(template.getMachine());
		template1.setWork(template.getWork());
		template1.setSubWork(template.getSubWork());
		template1.setItem(template.getItem());
		template1.setQty(template.getQty());
		template1.setUnit(template.getUnit());
		template1.setCostPrice(template.getCostPrice());
		template1.setAmount(template.getAmount());
		template1.setDel(1);
		return templateRepository.save(template1);
	}
	
	public TemplateTable deleteTemplatePermanently(TemplateTable template) {
		templateRepository.delete(template);
		return template;
	}
}
