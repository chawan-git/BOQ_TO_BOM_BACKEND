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
public class BOQTable {
	@Id
	private int id;
	@Column
	private int BOQId;
	@OneToOne
	private MachineMaster machine;
	@Column
	private String description;
	@OneToOne
	private WorkMaster work;
	@OneToOne
	private SubWorkMaster subWork;
	@Column
	private int qty;
	@OneToOne
	private UnitMaster unit;
	@Column
	private Double rate;
	@Column
	private Double amount;
	@Column
	private int del;

}
