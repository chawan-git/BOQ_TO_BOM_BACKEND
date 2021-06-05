/**
 * @Author Ashutosh Rao Chawan & Suggala Manasvi
 */
package com.aqsaindia.boqtobom.entities;

import javax.persistence.Entity;
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
public class GSTTable {
	@Id
	private int id;
	@NotNull
	private String state;
	@NotNull
	private String gstNumber;
	@OneToOne
	private VendorMaster vendor;
	@NotNull
	private int del;
	
}
