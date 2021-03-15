package com.vti.frontend;

import java.io.File;
import java.io.IOException;

import com.vti.Utils.FileManager;

public class Program3 {
	public static void main(String[] args) throws Exception {
		FileManager files = new FileManager();
		// files.question1();

		// Create new file:
//		try {
//			FileManager.createNewFile("C:\\Users\\MyNguyen\\Desktop\\my123.docx");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

		// Delete file:

//		try {
//			FileManager.deleteFile("C:\\Users\\MyNguyen\\Desktop\\my123.doc");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

		// Check file or Folder
		// files.isFolder("C:\\Users\\MyNguyen\\Desktop\\my123.txt");

		// getAllFile
//		try {
//			files.getAllFileName("C:\\Users\\MyNguyen\\Desktop");
//		} catch (Exception ioe) {
//			System.out.println(ioe.getMessage());
//		}

		try {
			files.copyFile("C:\\Users\\MyNguyen\\Desktop\\StudentInformation.txt", "C:\\Users\\MyNguyen\\Desktop", "Mynguyen.txt");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		
	}
}
