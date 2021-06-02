/**
 * 
 */
package com.aqsaindia.boqtobom.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 *
 */
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TemplateTable {
	@Id
	private int id;
	@OneToOne
	private MachineMaster machine;
	@OneToOne
	private WorkMaster work;
	@OneToOne
	private SubWorkMaster subWork;
	@OneToOne
	private ItemMaster item;
	@Column
	private int qty;
	@OneToOne
	private UnitMaster unit;
	@Column
	private Double costPrice;
	@Column
	private Double amount;
	@Column
	private int del;

}
