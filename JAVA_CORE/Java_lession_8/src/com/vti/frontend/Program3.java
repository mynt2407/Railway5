package com.vti.frontend;

import com.vti.backend.Exercise3_Generic;
import com.vti.entity.Employee;
import com.vti.entity.MyMap;
import com.vti.entity.Student;
import com.vti.entity.Student_gen;

public class Program3 {
	public static <K, V> void main(String[] args) {

		Student student1 = new Student("My Nguyen");
		Student student2 = new Student("My Nguyen1");
		Student student3 = new Student("My Nguyen2");

		Integer[] arrayInt = { 1, 3, 7, 10 };
		Float[] arrayFloat = { 3f, 8.8f, 2.6f };
		Long[] arrayLong = { 4l, 9l, 10l, 45l };

		Integer[] salaryE1 = { 100, 350, 600 };
		Float[] salaryE2 = { 300f, 250f, 700f };
		Double[] salaryE3 = { 220d, 330d, 630d };

		Employee<Integer> employ1 = new Employee<Integer>(1, "My nguyen 1", salaryE1);
		Employee<Float> employ2 = new Employee<Float>(2, "My nguyen 2", salaryE2);
		Employee<Float> employ3 = new Employee<Float>(3, "My nguyen 3", salaryE2);

		MyMap<String, String> mymap1 = new MyMap<String, String>("mynt@gmail.com", "ABC");
		MyMap<Integer, String> mymap2 = new MyMap<Integer, String>(4, "ABCD");
		MyMap<String, String> mymap3 = new MyMap<String, String>("My nguyen", "ABCDE");

		Exercise3_Generic ex3 = new Exercise3_Generic();
		// ex3.question1();
//	ex3.print(4);
//	ex3.print(4.0f);
//	ex3.print(student1);
//	ex3.print(student2);
//		ex3.question4(arrayFloat);
//		for (Integer integer : salaryE1) {
//			System.out.println(integer);
//		}
		ex3.question6(mymap1.getKey());
		ex3.question6(mymap2.getKey());
		ex3.question6(mymap3.getKey());
	}
}
