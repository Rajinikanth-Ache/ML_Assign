package com.bhavna.sbe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_springboot")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String nme;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name="SALARY")
	private double salary;
	
	@Column(name="JOB_TITLE")
	private String job_title;
	
	@Column(name="GENDER")
	private String Gender;
	
	public Employee() {
		super();
	}

	public Employee(Integer id, String nme, Integer age, double salary, String job_title, String gender) {
		super();
		this.id = id;
		this.nme = nme;
		this.age = age;
		this.salary = salary;
		this.job_title = job_title;
		Gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNme() {
		return nme;
	}

	public void setNme(String nme) {
		this.nme = nme;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nme=" + nme + ", age=" + age + ", salary=" + salary + ", job_title="
				+ job_title + ", Gender=" + Gender + "]";
	}
	
	
	
}
