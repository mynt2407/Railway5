package com.vti.fornted;

import java.awt.dnd.DropTargetContext;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.vti.entity.Exercise4_Transaction;

public class Program4 {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		Exercise4_Transaction ex4 = new Exercise4_Transaction();
		
		ex4.transaction();
		
	}
}
