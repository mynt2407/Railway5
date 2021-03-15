package com.vti.frontend;

import java.util.List;

import com.vti.datalayer.EmployeeRepository;
import com.vti.entity.Employee;

public class EmployeeTest {
	public static void main(String[] args) {

		EmployeeRepository employeeRepository = new EmployeeRepository();

		System.out.println("***********GET ALL EMPLOYEE***********");
		List<Employee> employees = employeeRepository.getAllEmployee();
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		System.out.println("\n\n***********CREATE EMPLOYEE ***********");
		Employee employee = new Employee();
		employee.setEmail("mynt2407@gmail.com");
		employee.setFullName("Neo Nguyen");
		employee.setUserName("My Nguyen");
		employee.setWorkingNumberOfYear((short) 3);
		
		employeeRepository.createEmployee(employee);

	}
}
