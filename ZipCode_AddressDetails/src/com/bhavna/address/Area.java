package com.bhavna.address;

public class Area extends State{
	private Long zipCode;
	private String areaName;
	
	public Area() {
		super();
	}
	
	public Area(String countryName, String stateName,Long zipCode,String areaName) {
		super(countryName, stateName);
		this.zipCode=zipCode;
		this.areaName=areaName;
	}
	
	public Long getZipCode() {
		return zipCode;
	}
	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "[CountryName="+getCountryName()+" , stateName="+getStateName()+"  , areaName="+areaName+" , zipCode=" + zipCode + "]";
	}
	
	
	
}
