import java.util.Date;



public class Method_ex6 {
	public static void main(String[] args) {
//	Question 1:
//		Táº¡o method Ä‘á»ƒ in ra cÃ¡c sá»‘ cháºµn nguyÃªn dÆ°Æ¡ng nhá»� hÆ¡n 10
		// create account

		Account account1 = new Account();
		account1.id = 7;
		account1.email = "duynguyen1@gmail.com";
		account1.userName = "duy.nguyenngoc";
		account1.fullName = "Nguyen Ngoc Duy";
		account1.createDate = new Date(95, 11, 20);
		account1.gender = Gender.MALE;

		Account account2 = new Account();
		account2.id = 4;
		account2.email = "mynt2407@gmail.com";
		account2.userName = "mynguyen";
		account2.fullName = "Nguyen Thi My";
		account2.createDate = new Date(93, 10, 01);
		account2.gender = Gender.UNKNOW;

		Account account3 = new Account();
		account3.id = 2;
		account3.email = "tongnhung@gmail.com";
		account3.userName = "nhung.tong";
		account3.fullName = "Tong Thi Nhung";
		account3.createDate = new Date(91, 0, 12);
		account3.gender = Gender.FEMALE;

		Account[] accounts = { account1, account2, account3 };

		so_chan();
//		get_account_if(accounts);
//		get_int();
	}

	public static void so_chan() {
		int i = 0;
		while (i < 10) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}

	}

//	Question 2:
//	Táº¡o method Ä‘á»ƒ in thÃ´ng tin cÃ¡c account

	public static void get_account_if(Account[] accounts) {
		for (int j = 0; j < accounts.length; j++) {
			System.out.println("id la: " + accounts[j].id);
			System.out.println("Fullname la: " + accounts[j].fullName);
			System.out.println("Email la: " + accounts[j].email);
			System.out.println("Create Date la: " + accounts[j].createDate);
			System.out.println("\n");
		}

	}

//	Question 3:
//	Táº¡o method Ä‘á»ƒ in ra cÃ¡c sá»‘ nguyÃªn dÆ°Æ¡ng nhá»� hÆ¡n 10

	public static void get_int() {
		int z = 0;
		while (z < 10) {
			System.out.println("So nguyen duong la: " + z);
			z++;
		}
	}

	
	

	
	
}
