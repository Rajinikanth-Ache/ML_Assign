package com.bhavna.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class PreparedStatementClass {
	String url="jdbc:sqlserver://localhost;databaseName=employeedb;username=sa;password=Bhavna@123";
	Scanner sc=new Scanner(System.in);
	
	public void getAllData() {
		String query="select * from EmployeeTable e inner join DepartmentTable d on e.deptId=d.deptId";
		try {
			Connection connection=DriverManager.getConnection(url);
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.print("id : "+resultSet.getInt("empId")+"\t");
				System.out.print("name : "+resultSet.getString("empName")+"\t");
				System.out.print("salary : "+resultSet.getInt("salary")+"\t");
				System.out.print("date : "+resultSet.getDate("hiredate")+"\t");
				System.out.print("dept Id : "+resultSet.getInt("deptId")+"\t");
				System.out.print("dept Name : "+resultSet.getString("deptName")+"\t");
				System.out.print("location : "+resultSet.getString("location")+"\n");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getDataById(int id) {
		String query="select * from EmployeeTable e inner join DepartmentTable d ON e.deptid=d.deptId where e.empId=?";
			try {
				Connection connection=DriverManager.getConnection(url);
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				ResultSet resultSet=preparedStatement.executeQuery();
				while(resultSet.next()) {
					System.out.print("id : "+resultSet.getInt("empId")+"\t");
					System.out.print("name : "+resultSet.getString("empName")+"\t");
					System.out.print("salary : "+resultSet.getInt("salary")+"\t");
					System.out.print("date : "+resultSet.getDate("hiredate")+"\t");
					System.out.print("dept Id : "+resultSet.getInt("deptId")+"\t");
					System.out.print("dept Name : "+resultSet.getString("deptName")+"\t");
					System.out.print("location : "+resultSet.getString("location")+"\n");
				}
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void updateById(int id) {
		String query="update EmployeeTable set salary=? where empId=?";
			try {
				Connection connection=DriverManager.getConnection(url);
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				System.out.println("enter the salary :");
				int sal=sc.nextInt();
				preparedStatement.setInt(1, sal);
				preparedStatement.setInt(2, id);
				preparedStatement.executeUpdate();
				System.out.println("updated successfully");
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void insertDepartment() {
		String query="insert into DepartmentTable"+"(deptId,deptName,location) values"+"(?,?,?)";
			try {
				Connection connection=DriverManager.getConnection(url);
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				
				System.out.println("enter the departmentId :");
				int deptId=sc.nextInt();
				
				if(isPresentDepartment(deptId)) {
					throw new IllegalArgumentException("this department is already present");
				}else {
					preparedStatement.setInt(1, deptId);
				}
				
				System.out.println("enter Department Name");
				String name=sc.next();
				preparedStatement.setString(2, name);
				
				System.out.println("enter location");
				String location=sc.next();
				preparedStatement.setString(3, location);
				
				preparedStatement.executeUpdate();
				System.out.println("data inserted successfully");
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	public void insertEmployee() {
		String query="insert into EmployeeTable"+"(empId,empName,salary,hiredate,deptId) values"+"(?,?,?,?,?)";
			try {
				Connection connection=DriverManager.getConnection(url);
				PreparedStatement preparedStatement=connection.prepareStatement(query);
				System.out.println("enter the id :");
				int id=sc.nextInt();
				if(isPresentEmployee(id)) {
					throw new IllegalArgumentException("this employee is already present");
				}else {
					preparedStatement.setInt(1, id);
				}
				
				System.out.println("enter the Name :");
				String name=sc.next();
				preparedStatement.setString(2, name);
				
				System.out.println("enter the salary :");
				int sal=sc.nextInt();
				preparedStatement.setInt(3, sal);
				
				System.out.println("entyer the date in the format \"YYYY-MM-DD\" :");
				String date=sc.next();
				preparedStatement.setDate(4,java.sql.Date.valueOf(date));
				
				System.out.println("enter the departmentId :");
				int deptId=sc.nextInt();
				preparedStatement.setInt(5, deptId);
				
				preparedStatement.executeUpdate();
				System.out.println("data inserted successfully");
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void getGreaterSalary() {
		//String query3="select d.deptName,count(*) as total from EmployeeTable e inner join DepartmentTable d on e.deptId=d.deptId where e.salary>30000 group by d.deptName";
		String query3="select d.deptName,count(e.empId) as total from (select * from EmployeeTable where salary>30000)  e inner join DepartmentTable d on e.deptId=d.deptId group by d.deptName";
		try {
			Connection connection=DriverManager.getConnection(url);
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(query3);
			while(resultSet.next()) {
				System.out.print("dept Name : "+resultSet.getString("deptName")+"\t");
				System.out.print("total employees : "+resultSet.getString("total")+"\n");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isPresentEmployee(int id) {
		String query="select * from EmployeeTable";
		try {
			Connection connection=DriverManager.getConnection(url);
			Statement statement=connection.createStatement();
			ResultSet res=statement.executeQuery(query);
			while(res.next()){
				if(res.getInt("empId")==id) {
					return true;
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isPresentDepartment(int id) {
		String query="select * from DepartmentTable";
		try {
			Connection connection=DriverManager.getConnection(url);
			Statement statement=connection.createStatement();
			ResultSet res=statement.executeQuery(query);
			while(res.next()){
				if(res.getInt("deptId")==id) {
					return true;
				}
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
