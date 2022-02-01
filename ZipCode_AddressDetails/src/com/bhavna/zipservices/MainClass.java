package com.bhavna.zipservices;

import java.util.Scanner;

import com.bhavna.address.Area;

public class MainClass {
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		ZipServiceHelper zip2=new ZipServiceHelper();
		ZipServiceV11 zip3=zip2.getImplementation();
		int val = 0;
		
		do {
			System.out.println("enter 1 to get the address by entering zip code");
			System.out.println("enter 2 to get all available zipcodes here");
			System.out.println("enter 3 to add the new zipcode and details");
			int n=sc.nextInt();
			switch(n) {
			
			case 1:
				System.out.println("enter the zip code");
				Long zz=sc.nextLong();
				Area area1=new Area();
				area1.setZipCode(zz);
				area1=zip3.getDetails(area1.getZipCode());
				System.out.println(area1);
				break;
				
			case 2:
				zip3.getRecords();
				break;
				
			case 3:
				System.out.println("enter zipcode : ");
				Long zipp=sc.nextLong();
				if(zip3.isExists(zipp)) {
					System.out.println("zip Code is already exists");
					break;
				}
				System.out.println("enter Country name : ");
				String cName=sc.next();
				System.out.println("enter State Name : ");
				String sName=sc.next();
				zip3.addrecords(zipp, new Area(cName, sName, zipp));
				System.out.println("***added successfully***");
				break;
				
			default:
				System.out.println("select the valid option");
				break;
			}
			
			System.out.println("do you wnat to continue ? enter 5");
			val=sc.nextInt();
			if(val!=5){
				break;
			}
			
		}while(val==5);
	
	}
}
