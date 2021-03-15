package com.vti.fornted;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.Exercise1_Basic;

public class Program1 {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		Exercise1_Basic ex1 = new Exercise1_Basic();
		ex1.readPosition();
		// ex1.createPosition();
		// ex1.updatePosition();
		// ex1.deletePosition();
	}
}
