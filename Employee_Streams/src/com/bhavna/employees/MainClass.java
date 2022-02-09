package com.bhavna.employees;

public class MainClass {

		public static void main(String[] args) {
			EmployeeData emp=new EmployeeData();
			
			System.out.println("employees name start with S cout :");
			emp.getNameStartsWithS();
			System.out.println("-----------------------------------------------------------\n");
			
			System.out.println("employees in location in hyderabad :\n");
			emp.parallelLocationHyderabad();
			System.out.println("-----------------------------------------------------------\n");
			
			System.out.println("employees with group by location:\n");
			emp.getDataInMap();
			System.out.println("-----------------------------------------------------------\n");
			
			System.out.println("employees with greater than one lakh salary:\n");
			emp.salGreaterthanOneLakh();
			System.out.println("-----------------------------------------------------------\n");
			
			System.out.println("sorting:\n");
 			emp.sortingLogic();
 			
 			//emp.getAll();
		}
}
