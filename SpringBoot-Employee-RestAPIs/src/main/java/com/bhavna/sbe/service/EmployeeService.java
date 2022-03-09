package com.bhavna.sbe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bhavna.sbe.entity.Employee;
import com.bhavna.sbe.exceptions.IdNotFoundException;
import com.bhavna.sbe.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo repo;
	
	public Employee addORUpdateEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	public Employee getById(Integer id) {
		Optional<Employee> emp= repo.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}else {
			throw new IdNotFoundException("Id is not present in bd");
		}
	}
	
	public void deleteById(Integer id) {
		Optional<Employee> emp= repo.findById(id);
		if(emp.isPresent()) {
			repo.deleteById(id);
		}else {
			throw new IdNotFoundException("Id is not present in bd");
		}
	}
	
	public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize)
    {
        Pageable paging = PageRequest.of(pageNo-1, pageSize);
        Page<Employee> pagedResult = repo.findAll(paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }
	
	
}
