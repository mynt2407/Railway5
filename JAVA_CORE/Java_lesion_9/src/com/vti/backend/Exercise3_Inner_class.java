package com.vti.backend;

import com.vti.entity.CPU;
import com.vti.entity.CPU.Processor;
import com.vti.entity.CPU.Ram;
import com.vti.entity.Car;

public class Exercise3_Inner_class {

//	Question 1:
//		Tạo class CPU có property: price
//		Tạo 2 inner class Processor, Ram
//		Với Processor có các property: coreAmount, menufacturer và
//		method getCache() và return ra 4.3
//		Với Ram có các property: memory, menufacturer và method
//		getClockSpeed() và return ra 5.5
//		Sau đó khởi tạo object CPU và in ra cache của Processor va clockSpeed của Ram

	public static void question1() {
		CPU cpu = new CPU();

		CPU.Processor processor = cpu.new Processor(4, "ABC");
		System.out.println(processor.getCache());

		CPU.Ram ram = cpu.new Ram(3, "XYZ");
		System.out.println(ram.getClockSpeed());
	}

//	Question 2:
//		Tạo Car có property: name, type
//		Tạo inner class Engine có property engineType và tạo getter, setter cho
//		property engineType
//		Khởi tạo object Car có name = Mazda, type = 8WD, có loại động cơ là
//		"Crysler".
//		Sau đó in ra thông tin của động cơ
	public static void question2() {
		Car car = new Car("Mazda", "8WD");
		Car.Enginer enginer = car.new Enginer("Crysler");
		System.out.println(enginer.getEngineType());
	}

}
