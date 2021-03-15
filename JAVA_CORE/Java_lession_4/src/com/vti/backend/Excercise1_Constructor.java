package com.vti.backend;

import java.util.Date;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Student_Ex;

public class Excercise1_Constructor {

//		Question 1:
//			Tạo constructor cho department:
//			a) không có parameters
//			b) Có 1 parameter là nameDepartment và default id của
//			Department = 0
//			Khởi tạo 1 Object với mỗi constructor ở trên

	public void question1() {

		Department department = new Department();

		Department department1 = new Department("Nguyen thi My");

		department1.setName("my nguyen");
		department1.setid((byte) 5);

		System.out.println(department1.getid());
		System.out.println(department1.getName());

		System.out.print("\n");
	}

//		Question 2:
//			Tạo constructor cho Account:
//			a) Không có parameters
//			b) Có các parameter là id, Email, Username, FirstName,
//			LastName (với FullName = FirstName + LastName)
//			c) Có các parameter là id, Email, Username, FirstName,
//			LastName (với FullName = FirstName + LastName) và
//			Position của User, default createDate = now
//			d) Có các parameter là id, Email, Username, FirstName,
//			LastName (với FullName = FirstName + LastName) và
//			Position của User, createDate
//			Khởi tạo 1 Object với mỗi constructor ở trên

	public void question2() {
// Cau a
		Account account = new Account();
// Cau b
		Account account1 = new Account(2, "duynn03@gmail.com", "DuyNguyenNgoc", "Duy", "Nguyen Ngoc",
				"Nguyen Ngoc Duy");
		account1.setId(5);
		System.out.println(account1.getId());

		account1.setEmail("my123@gmail.com");
		System.out.println(account1.getEmail());

		account1.setFullName("Neo Nguye");
		System.out.println(account1.getFullName());
		System.out.print("\n");
// cau c
		Account account2 = new Account(3, "mynt2407", "mynguyen", "My", "Nguyen Thi", "Nguyen Thi My", "Sale", null);
		System.out.println(account2.getEmail());
		System.out.println(account2.getFullName());
		System.out.println(account2.getPostition());
	}

//	Question 3:
//		Tạo constructor cho Group:
//		a) không có parameters
//		b) Có các parameter là GroupName, Creator, array Account[]
//		accounts, CreateDate
//		c) Có các parameter là GroupName, Creator, array String[]
//		usernames , CreateDate
//		Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
//		username, các thông tin còn lại = null).
//		Khởi tạo 1 Object với mỗi constructor ở trên
	public void question3() {
		// cau a
		Group group = new Group();
		// cau b

		Account account1 = new Account(2, "duynn03@gmail.com", "DuyNguyenNgoc", "Duy", "Nguyen Ngoc",
				"Nguyen Ngoc Duy");
		Account account2 = new Account(3, "mynt2407", "mynguyen", "My", "Nguyen Thi", "Nguyen Thi My", "Sale", null);
		Account account3 = new Account(4, "nguyenthehung@vti.com", "NguyenTheHung", "Hung", "Nguyen the",
				"Nguyen the hung");
		Account[] accounts = { account1, account2, account3 };

		Group group1 = new Group("Nhom Java", new Date(90, 9, 10), "Nguyen ngoc duy", accounts);

		// Cau c
		String username1 = "Nguyen Thi Mai Anh";
		String username2 = "Nguyen Ngoc Lam ANh";
		String username3 = "Tran Van Hien";

		String[] userNames = { username1, username2, username3 };

		Group groupn = new Group("Group 1", new Date(90, 10, 1), "Nguyen Ngoc Duy", userNames);
		System.out.println(groupn.getCreator());
		System.out.println(groupn.getGroupName());
		for (String string : userNames) {
			System.out.println(string);
		}
	}

}
