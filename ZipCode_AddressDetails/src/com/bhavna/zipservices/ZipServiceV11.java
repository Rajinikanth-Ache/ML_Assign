package com.bhavna.zipservices;

import com.bhavna.address.Area;

public interface ZipServiceV11 {
	public Area getDetails(Long zip);
	public boolean isExists(Long zip);
	public void getRecords();
	public void addrecords(Long zzip,Area area);
}
