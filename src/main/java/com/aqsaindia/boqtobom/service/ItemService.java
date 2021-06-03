/**
 * @author Ashutosh Rao Chawan & Suggala Manasvi 
 */
package com.aqsaindia.boqtobom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqsaindia.boqtobom.entities.ItemMaster;
import com.aqsaindia.boqtobom.repository.IItemRepository;

@Service
public class ItemService {

	@Autowired
	private IItemRepository itemRepository;

	public ItemMaster insertItem(ItemMaster item) {
		return itemRepository.save(item);
	}

	public ItemMaster findItemById(int id) {
		return itemRepository.findById(id).get();
	}

	public ItemMaster findItemByName(String itemName) {
		return itemRepository.findByItemName(itemName);
	}

	public List<ItemMaster> findAllItems() {
		return itemRepository.findAll();
	}

	public ItemMaster updateItem(ItemMaster item) {
		ItemMaster item1 = itemRepository.findById(item.getId()).get();
		item1.setId(item.getId());
		item1.setItemName(item.getItemName());
		item1.setDel(item.getDel());
		return itemRepository.save(item1);
	}

	public ItemMaster deleteItem(ItemMaster item) {
		ItemMaster item1 = itemRepository.findById(item.getId()).get();
		item1.setId(item.getId());
		item1.setItemName(item.getItemName());
		item1.setDel(1);
		return itemRepository.save(item1);
	}

	public ItemMaster deleteItemPermanently(ItemMaster item) {
		itemRepository.delete(item);
		return item;
	}

}
