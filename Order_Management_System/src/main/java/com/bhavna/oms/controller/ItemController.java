package com.bhavna.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.oms.model.Item;
import com.bhavna.oms.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService serv;
	
	@GetMapping("/list")
	public List<Item> getAllItems(){
		return serv.getAll();
	}
}
