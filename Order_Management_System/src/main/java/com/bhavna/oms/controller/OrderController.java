package com.bhavna.oms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.oms.model.Orders;
import com.bhavna.oms.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService serv;
	
	@GetMapping("/list")
	public List<Orders> getAllOrders(){
		return serv.geAlltOrders();
	}
	
	@PostMapping("/add")
	public String addOrder(@RequestBody Orders order) {
		 serv.addOrder(order);
		return "added successfully";
	}
	
	//getting orders by category id
	@GetMapping("/cat/{id}")
	public List<Orders> getOrderByCategory(@PathVariable("id") Integer id){
		return serv.getOrdersByCategory(id);
	}
	
	//delete all the orders with category id
	@DeleteMapping("delete/cat/{id}")
	public boolean deleteOrdersbyCategory(@PathVariable("id") Integer id) {
		return serv.deleteOrdersByCategory(id);
	}
	
	@GetMapping("/get/{id}")
	public Orders getOrderById(@PathVariable("id") Integer id) {
		return serv.getOrderById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteOrderById(@PathVariable("id") Integer id) {
		serv.deleteOrder(id);
		return "deleted successfully";
	}
	
	@PutMapping("/update/{order_id}")
	public Orders updateByCategory(@PathVariable("order_id") Integer order_id,@RequestBody Orders order) {
		return	serv.updateOrder(order_id, order);

	}
	
	@PatchMapping("/patch/{id}")
	public Orders patchOrder(@PathVariable("id") Integer id, @RequestParam(name = "item", required=false) Integer item_id,  @RequestParam(name = "quantity", required=false) Integer quantity) {
		return serv.patchOrder(id, item_id, quantity);
		
	}
}
