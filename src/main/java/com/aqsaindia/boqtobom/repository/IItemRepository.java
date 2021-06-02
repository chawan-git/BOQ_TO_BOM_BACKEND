package com.aqsaindia.boqtobom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aqsaindia.boqtobom.entities.ItemMaster;

/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi
 * 
 **/

@Repository
public interface IItemRepository extends JpaRepository<ItemMaster, Integer> {

	@Query("SELECT item from ItemMaster item WHERE item.itemId = ?1")
	public ItemMaster findByItemId(String itemId);

	@Query("SELECT item FROM  ItemMaster item WHERE item.itemName = ?1")
	public ItemMaster findByItemName(String itemName);

}
