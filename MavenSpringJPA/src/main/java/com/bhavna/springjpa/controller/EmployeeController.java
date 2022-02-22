package com.bhavna.springjpa.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.springjpa.entity.Employee;
import com.bhavna.springjpa.service.EmployeeService;

@RestController
public class EmployeeController {

	@RequestMapping("/get")
	public String get() {
		return "got it";
	}
	
	@Autowired
	EmployeeService serv;
	
	    @RequestMapping(value="/list",method = RequestMethod.GET,produces = {MediaType.APPLICATION_XML_VALUE})
	    public List<Employee> listEmployees() {
	      List<Employee> emplist= serv.getAll();
	      return emplist;
	    }
	    
	    
	    @RequestMapping(value="/emp/{id}",method = RequestMethod.GET,produces = {MediaType.APPLICATION_XML_VALUE})
	    public Employee getById(@PathVariable("id") Integer id) throws IOException {
	    	return serv.getEmp(id);
	    }
	    
	    @RequestMapping(value="/getActive",method = RequestMethod.GET,produces = {MediaType.APPLICATION_XML_VALUE})
	    public List<Employee> getActive(){
	    	return serv.getActive();
	    }
}
