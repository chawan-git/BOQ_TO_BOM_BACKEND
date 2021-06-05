/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
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

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactTable {
	@Id
	private int id;
	@Column
	@NotNull
	private String contactName;
	@Column
	@NotNull
	private String phoneNumber;
	@Column
	@NotNull
	private String emailId;
	@OneToOne
	private DepartmentMaster department;
	@OneToOne
	private VendorMaster vendor;
	@Column
	@NotNull
	private int del;

}
