package com.bhavna.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="channel")
public class Channel {
	
	@Id
	@Column(name="C_ID")
	private Integer c_id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LOCATION")
	private String location;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="c_id")
	private List<Reporter> reporters;
	
	public Channel() {
		super();
	}
	
	public Channel(Integer id, String name, String location, List<Reporter> reporters) {
		super();
		this.c_id = id;
		this.name = name;
		this.location = location;
		this.reporters = reporters;
	}
	public Integer getId() {
		return c_id;
	}
	public void setId(Integer id) {
		this.c_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocaton() {
		return location;
	}
	public void setLocaton(String location) {
		this.location = location;
	}
	public List<Reporter> getReporters() {
		return reporters;
	}
	public void setReporters(List<Reporter> reporters) {
		this.reporters = reporters;
	}
	@Override
	public String toString() {
		return "Channel [id=" + c_id + ", name=" + name + ", location=" + location + ", reporters=" + reporters + "]";
	}
	
	
}
