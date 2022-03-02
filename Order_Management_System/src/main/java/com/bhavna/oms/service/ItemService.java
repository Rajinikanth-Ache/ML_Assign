package com.bhavna.oms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.oms.model.Item;
import com.bhavna.oms.repo.ItemRepo;

@Service
public class ItemService {

	@Autowired
	ItemRepo repo;
	
	public List<Item> getAll(){
		return repo.findAll();
	}
}
