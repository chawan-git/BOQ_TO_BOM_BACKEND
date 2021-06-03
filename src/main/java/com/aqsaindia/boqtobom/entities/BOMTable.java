/**
 * 
 */
package com.aqsaindia.boqtobom.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

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
public class BOMTable {
	@Id
	private int id;
	@Column
	@NotNull
	private String BOMId;
	@OneToOne
	private BOQTable BOQ;
	@OneToOne
	private MachineMaster machine;
	@OneToOne
	private WorkMaster work;
	@OneToOne
	private SubWorkMaster subWork;
	@OneToOne
	private ItemMaster item;
	@Column
	@NotNull
	private int qty;
	@OneToOne
	private UnitMaster unit;
	@Column
	@NotNull
	private Double rate;
	@Column
	@NotNull
	private Double amount;
	@Column
	@NotNull
	private int del;

}
