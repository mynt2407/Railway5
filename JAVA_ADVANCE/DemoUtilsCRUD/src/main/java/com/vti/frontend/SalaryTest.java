package com.vti.frontend;

import java.util.List;

import com.vti.Enumerate.PositionName;
import com.vti.Enumerate.SalaryName;
import com.vti.datalayer.PositionRepository;
import com.vti.datalayer.SalaryRepository;
import com.vti.entity.Position;
import com.vti.entity.Salary;


public class SalaryTest {
	public static void main(String[] args) {

		SalaryRepository salaryRepository = new SalaryRepository();

		System.out.println("***********GET ALL POSITION***********");
		List<Salary> salarys = salaryRepository.getAllSalary();
		for (Salary salary : salarys) {
			System.out.println(salary);
		}
		
		
		System.out.println("\n\n***********CREATE POSITION ***********");
		Salary salary = new Salary();
		salary.setName(SalaryName.PM);
		salaryRepository.createSalary(salary);

		
	}
}
