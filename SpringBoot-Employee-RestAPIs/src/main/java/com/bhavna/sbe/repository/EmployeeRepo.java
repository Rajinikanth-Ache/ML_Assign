package com.bhavna.sbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhavna.sbe.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
