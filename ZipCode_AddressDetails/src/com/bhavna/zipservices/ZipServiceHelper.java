package com.bhavna.zipservices;


public class ZipServiceHelper{

	public ZipServiceV11 getImplementation() {
		return new ZipServiceV12();
	}
}
