package com.bhavna.oms.service;

import java.util.ArrayList;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.oms.exceptionhandler.EmptyException;
import com.bhavna.oms.model.Category;
import com.bhavna.oms.model.Orders;
import com.bhavna.oms.repo.ItemRepo;
import com.bhavna.oms.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo repo;
	
	@Autowired
	ItemRepo itemRepo;
	
	Category category=new Category();
	
	public List<Orders> geAlltOrders(){
		return repo.findAll();
	}
	
	public String addOrder(Orders order) {
			Long price=itemRepo.getById(order.getItem().getId()).getPrice();
			if((order.getQuantity()<=0)) {
				throw new EmptyException();
			}
			else {
				order.setPrice(order.getQuantity()*price);
				 repo.save(order);
				 return "added successfully";
			}
	}
	
	//getting orders by category id
	public List<Orders> getOrdersByCategory(Integer id){
		List<Orders> lili=new ArrayList<>();
		repo.findAll().forEach(s->{
			if(s.getItem().getCategory().getId().equals(id)) {
				lili.add(s);
			}
		});
		return lili;
	}
	
	//delete all the orders with category id
	public boolean deleteOrdersByCategory(Integer id) {
		repo.findAll().forEach(s->{
			if(s.getItem().getCategory().getId().equals(id)) {
				repo.delete(s);
			}
		});
		return true;
	}
	
	public Orders getOrderById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void deleteOrder(Integer id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}else {
			throw new NoSuchElementException();
		}
	}
	
	public Orders updateOrder(Integer order_id,Orders orders) {
		if(repo.existsById(order_id)) {
			Long price=itemRepo.getById(orders.getItem().getId()).getPrice();
			if((orders.getQuantity()<=0)) {
				throw new EmptyException();
			}
			else {
				orders.setPrice(orders.getQuantity()*price);
				return repo.save(orders);
			}
			
		}else {
			throw new NoSuchElementException();
		}
	}
	
	
	public Orders patchOrder(Integer id,Integer item_id ,Integer quantity) {
			Orders order = repo.findById(id).get();
			if(quantity!=null) order.setQuantity(quantity);
			if(item_id!=null) order.setItem(itemRepo.findById(item_id).get());
			Long price=itemRepo.getById(order.getItem().getId()).getPrice();
			order.setPrice(order.getQuantity()*price);
			System.out.println(order);
			return repo.save(order);
	}
	
	
}
