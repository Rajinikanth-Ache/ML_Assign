package com.bhavna.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStatementClass {
	Scanner sc=new Scanner(System.in);
	
	public void getAllData(String url) {
		String call="{call allEmployeesWithDepartment}";
		try {
			Connection connection=DriverManager.getConnection(url);
			CallableStatement callableStatement=connection.prepareCall(call);
			ResultSet rs=callableStatement.executeQuery();
			while(rs.next()) {
				System.out.print("id : "+rs.getInt("empId")+"\t");
				System.out.print("name : "+rs.getString("empName")+"\t");
				System.out.print("salary : "+rs.getInt("salary")+"\t");
				System.out.print("date : "+rs.getDate("hiredate")+"\t");
				System.out.print("dept Id : "+rs.getInt("deptId")+"\t");
				System.out.print("dept Name : "+rs.getString("deptName")+"\t");
				System.out.print("location : "+rs.getString("location")+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getDataById(String url) {
		String call="{call allDataById(?)}";
		try {
			Connection connection=DriverManager.getConnection(url);
			CallableStatement callableStatement=connection.prepareCall(call);
			System.out.println("enter the id here:");
			int id=sc.nextInt();
			callableStatement.setInt(1, id);
			ResultSet rs=callableStatement.executeQuery();
			while(rs.next()) {
				System.out.print("id : "+rs.getInt("empId")+"\t");
				System.out.print("name : "+rs.getString("empName")+"\t");
				System.out.print("salary : "+rs.getInt("salary")+"\t");
				System.out.print("date : "+rs.getDate("hiredate")+"\t");
				System.out.print("dept Id : "+rs.getInt("deptId")+"\t");
				System.out.print("dept Name : "+rs.getString("deptName")+"\t");
				System.out.print("location : "+rs.getString("location")+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateSalaryById(String url) {
		String call="{call updateSalary(?,?)}";
		try {
			Connection connection=DriverManager.getConnection(url);
			CallableStatement callableStatement=connection.prepareCall(call);
			System.out.println("enter the salary here:");
			int sal=sc.nextInt();
			callableStatement.setInt(2, sal);
			System.out.println("enter the id here:");
			int id=sc.nextInt();
			callableStatement.setInt(1, id);
			callableStatement.executeUpdate();
			System.out.println("updated successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getGreaterSalary(String url) {
		String call="{call greaterSalary}";
		try {
			Connection connection=DriverManager.getConnection(url);
			CallableStatement callableStatement=connection.prepareCall(call);
			ResultSet rs=callableStatement.executeQuery();
			while(rs.next()) {
				System.out.print("dept Name : "+rs.getString("deptName")+"\t");
				System.out.print("total employees : "+rs.getString("total")+"\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertEmployeeData(String url) {
		String call="{call insertEmployee(?,?,?,?,?)}";
		try {
			Connection connection=DriverManager.getConnection(url);
			CallableStatement callableStatement=connection.prepareCall(call);
		
			System.out.println("enter the id :");
			int id=sc.nextInt();
			callableStatement.setInt(1, id);
			
			System.out.println("enter the Name :");
			String name=sc.next();
			callableStatement.setString(2, name);
			
			System.out.println("enter the salary :");
			int sal=sc.nextInt();
			callableStatement.setInt(3, sal);
			
			System.out.println("entyer the date in the format \"YYYY-MM-DD\" :");
			String date=sc.next();
			callableStatement.setDate(4,java.sql.Date.valueOf(date));
			
			System.out.println("enter the departmentId :");
			int deptId=sc.nextInt();
			callableStatement.setInt(5, deptId);
			
			callableStatement.executeUpdate();
			System.out.println("Inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertDepartment(String url) {
		String call="{call insertDepartment(?,?,?)}";
		try {
			Connection connection=DriverManager.getConnection(url);
			CallableStatement callableStatement=connection.prepareCall(call);
			System.out.println("enter the departmentId :");
			int deptId=sc.nextInt();
			callableStatement.setInt(1, deptId);
			
			System.out.println("enter Department Name");
			String name=sc.next();
			callableStatement.setString(2, name);
			
			System.out.println("enter location");
			String location=sc.next();
			callableStatement.setString(3, location);
			
			callableStatement.executeUpdate();
			System.out.println("inserted successfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
