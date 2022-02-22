package com.bhavna.springjpa.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@Entity
@Table(name="employee_maven")
public class Employee {
	
	@Id
	@Column(name="emp_id")
	private Integer id;
	
	@Column(name="emp_name")
	private String name;
	
	@Column(name="emp_sal")
	private Integer salary;
	
	@Column(name="hire_date")
	private Date date;
	
	@Column(name="dept_id")
	private Integer deptId;
	
	@Column(name="status")
	private String status;
	
	public Employee() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
