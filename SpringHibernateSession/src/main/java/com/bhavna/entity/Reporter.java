package com.bhavna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reporter")
public class Reporter {

	@Id
	@Column(name="R_ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name="MOBILENO")
	private String mobile_no;
	
	@Column(name="C_ID")
	private Integer c_id;
	
	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public Reporter() {
		super();
	}

	public Reporter(Integer id, String name, Integer age, String mobile_no) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.mobile_no = mobile_no;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	@Override
	public String toString() {
		return "Reporter [id=" + id + ", name=" + name + ", age=" + age + ", mobile_no=" + mobile_no +  "]";
	}

	

	
	
	
}
