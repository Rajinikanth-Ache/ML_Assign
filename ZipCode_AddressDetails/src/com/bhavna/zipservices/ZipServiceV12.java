package com.bhavna.zipservices;

import java.util.HashMap;
import java.util.Map;

import com.bhavna.address.*;

public class ZipServiceV12 implements ZipServiceV11{
	
	private static HashMap<Long, Area> hashMap;
	static{
		hashMap=new HashMap<>();
		hashMap.put(506356L, new Area("India", "Telangana", 506356L));
		hashMap.put(506357L, new Area("India", "Andhra", 506357L));
		hashMap.put(506358L, new Area("India", "MP", 506358L));
		hashMap.put(506359L, new Area("India", "MH", 506359L));
	}
	@Override
	public Area getDetails(Long zipCode) {
		if(hashMap.containsKey(zipCode)) {
			return hashMap.get(zipCode);
		}
		else {
			System.out.println("The Zip code is not available here");
			return null;
		}
	}
	@Override
	public void getRecords() {
		System.out.println("Total Zip Codes Available : "+hashMap.size());
		for(Map.Entry<Long, Area> map:hashMap.entrySet()) {
			System.out.println(map.getValue());
		}
		
	}
	
	@Override
	public void addrecords(Long zzip, Area area) {
			hashMap.put(zzip, area);
	}
	@Override
	public boolean isExists(Long zip) {
		if(hashMap.containsKey(zip)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
	
	

	
}
