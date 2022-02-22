package com.bhavna.springjpa.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.bhavna.springjpa.entity.Employee;
import com.bhavna.springjpa.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo repo;
	
	 @Transactional
	    public List<Employee> getAll() {
	        return repo.findAll();
	    }
	 
	 @Transactional
	 public List<Employee> getActive(){
		 List<Employee> lili=new ArrayList<>();
			repo.findAll().forEach(e->{
				if(e.getStatus().equals("ACTIVE")) {
					lili.add(e);
				}
			});
		 return lili;
	 }
	 
	 @Transactional
	 public Employee getEmp(Integer id) throws IOException {
		Optional<Employee> em= repo.findById(id);
		if(em.isPresent()) {
			return em.get();
		}else {
			throw new IOException("The id is not found");
		}
	 }
}
