package com.bhavna.preparedstatement;

import java.util.Scanner;

public class PreparedStatementMain {

	public static void main(String[] args) {
		PreparedStatementClass prepare=new PreparedStatementClass();
		Scanner sc=new Scanner(System.in);
		int rechoice=0;
		
		do {
		System.out.println("Enter 1 to get all the data :");
		System.out.println("Enter 2 to get data by Id :");
		System.out.println("Enter 3 to update salary by id");
		System.out.println("Enter 4 to Insert new Employee Details");
		System.out.println("Enter 5 to Insert new Deaprtment Details");
		System.out.println("Enter 6 to get the employees count whose salary > 3000");
		
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			prepare.getAllData();
			break;
		case 2:
			System.out.println("Enter id :");
			int id=sc.nextInt();
			prepare.getDataById(id);
			break;
		case 3:
			System.out.println("Enter id :");
			int id1=sc.nextInt();
			prepare.updateById(id1);
			break;
		case 4:
			prepare.insertEmployee();
			break;
		case 5:
			prepare.insertDepartment();
			break;
		case 6:
			prepare.getGreaterSalary();
			break;
		default:
			System.out.println("invalid option");
			break;
		}
		System.out.println("wnat to continue? enter 8...");
		rechoice=sc.nextInt();
		if(rechoice!=8) {
			System.out.println("thank you");
		}
		}while(rechoice==8);
	}
}
