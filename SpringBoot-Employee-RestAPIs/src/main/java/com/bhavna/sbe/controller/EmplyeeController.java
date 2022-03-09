package com.bhavna.sbe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.sbe.entity.Employee;
import com.bhavna.sbe.service.EmployeeService;

@RestController
public class EmplyeeController {

	@Autowired
	EmployeeService serv;
	
	@GetMapping("/get/{id}")
	public Employee getById(@PathVariable("id") Integer id) {
		return serv.getById(id);
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return serv.addORUpdateEmployee(employee);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return serv.addORUpdateEmployee(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		serv.deleteById(id);
		return "deleted successfully";
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getPageableEmployees( @RequestParam(name="page",defaultValue = "1") Integer pageNo, 
												@RequestParam(name="size",defaultValue = "10") Integer pageSize){
		List<Employee> lili=serv.getAllEmployees(pageNo, pageSize);
		return lili;
	}
}
