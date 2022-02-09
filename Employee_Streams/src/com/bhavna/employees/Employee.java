package com.bhavna.employees;

public class Employee {
	private String name;
	private Integer salary;
	private String location;
	
	public Employee(String name, Integer salary, String location) {
		this.name = name;
		this.salary = salary;
		this.location = location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return " [name=" + name + ", salary=" + salary + ", location=" + location + "]";
	}
	
}
