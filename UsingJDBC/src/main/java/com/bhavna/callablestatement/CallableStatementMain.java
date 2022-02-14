package com.bhavna.callablestatement;

public class CallableStatementMain {
	public static void main(String[] args) {
		String url="jdbc:sqlserver://localhost;databaseName=employeedb;username=sa;password=Bhavna@123";
		CallableStatementClass calClass=new CallableStatementClass();
		calClass.getAllData(url);
		calClass.getDataById(url);
		calClass.updateSalaryById(url);
		calClass.getGreaterSalary(url);
		calClass.insertEmployeeData(url);
		calClass.insertDepartment(url);
	}
}
