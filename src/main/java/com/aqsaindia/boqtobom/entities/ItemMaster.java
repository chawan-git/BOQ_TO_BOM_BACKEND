/**
 * 
 */
package com.aqsaindia.boqtobom.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class ItemMaster {
	@Id
	private int id;
	@Column
	@NotNull
	private int itemId;
	@Column
	@NotNull
	private String itemName;
	@Column
	@NotNull
	private int del;

}
