package com.vti.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PHONE  {

	protected List<Contact> contacts;
	protected Scanner scanner;

	public PHONE() {
		contacts = new ArrayList<Contact>();
		scanner = new Scanner(System.in);
	}

	
}
