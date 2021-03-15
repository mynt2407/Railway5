package com.vti.frontend;

import java.io.IOException;

import com.vti.Utils.IO_Stream;

public class Program4 {
	public static void main(String[] args) throws IOException {

		IO_Stream ios = new IO_Stream();
		
		try {
			ios.readFile("C:\\Users\\MyNguyen\\Desktop\\test.txt\\b");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
}