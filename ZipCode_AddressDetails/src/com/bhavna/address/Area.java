package com.bhavna.address;

public class Area extends State{
	private Long zipCode;
	
	public Area() {
		super();
	}
	
	public Area(String countryName, String stateName,Long zipCode) {
		super(countryName, stateName);
		this.zipCode=zipCode;
	}
	
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "[CountryName="+getCountryName()+" , stateName="+getStateName()+" , zipCode=" + zipCode + "]";
	}
	
	
	
}
