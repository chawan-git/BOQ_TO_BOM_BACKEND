/**
 * 
 */
package com.aqsaindia.boqtobom.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@NotNull
	private int qty;
	@OneToOne
	private UnitMaster unit;
	@Column
	@NotNull
	private Double costPrice;
	@Column
	@NotNull
	private Double amount;
	@Column
	@NotNull
	private int del;

}
