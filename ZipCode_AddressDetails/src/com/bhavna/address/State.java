package com.bhavna.address;

public class State extends Country{
	private String stateName;
	
	public State() {
		super();
	}

	public State(String countryName,String stateName) {
		super(countryName);
		this.stateName=stateName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	

}
