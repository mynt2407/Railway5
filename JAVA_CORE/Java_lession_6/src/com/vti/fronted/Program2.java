package com.vti.fronted;

import java.util.InputMismatchException;

import com.vti.backend.Exercise_2_Exception;
import com.vti.entity.InvValidAgeLessZero;
import com.vti.entity.ScannerUtils;

public class Program2 {
	public static void main(String[] args) throws Exception {
		Exercise_2_Exception ex2 = new Exercise_2_Exception();

		// ex2.question3();

		// ex2.inputAge1();

//		try {
//			Exercise_2_Exception.getIndex(5);
//		} catch (IndexOutOfBoundsException iob) {
//			System.out.println(iob.getMessage());
//		}

//		try {
//			Exercise_2_Exception.inputAge();
//		} catch (InvValidAgeLessZero ivalz) {
//			System.out.println(ivalz.getMessage());
//		} catch (InputMismatchException imee) {
//			System.out.println(imee.getMessage());
//		}

		// Cách 1: bắt lỗi dùng try catch như bình thường
//		try {
//			Exercise_2_Exception.inputAge1();
//		} catch (InputMismatchException ime) {
//			System.out.println(ime.getMessage());
//		}

		// Cách 2:
		// Exercise_2_Exception.inputAge1();

		// Với while (true) khi chạy sai chương trình không chết mà yêu cầu nhập lại. Do
		// vậy ko cần xử lý lỗi ở program

		Exercise_2_Exception.idInput();
	//Exercise_2_Exception.inputFloat();

	}

}
