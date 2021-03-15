import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Input_from_console {
	public static void main(String[] args) throws ParseException {
		// Possition

		Position Position1 = new Position();
		Position1.id = 1;
		Position1.positionName = PositionName.DEV;

		Position Position2 = new Position();
		Position2.id = 2;
		Position2.positionName = PositionName.TEST;

		Position Position3 = new Position();
		Position3.id = 3;
		Position3.positionName = PositionName.PM;
		Position[] positions = { Position1, Position2, Position3 };
		// create group
		Group group1 = new Group();
		group1.id = 1;
		group1.groupName = "Nhom Java Fresher";

		Group group2 = new Group();
		group2.id = 2;
		group2.groupName = "Nhom C# Fresher";

		Group group3 = new Group();
		group3.id = 3;
		group3.groupName = "Nhom PHP Fresher";
		Group[] groups = { group1, group2, group3 };

		// create account

		Account account1 = new Account();
		account1.id = 1;
		account1.email = "duynguyen1@gmail.com";
		account1.userName = "duy.nguyenngoc";
		account1.fullName = "Nguyen Ngoc Duy";
		account1.position = Position1;
		account1.createDate = new Date(95, 11, 20);
		account1.gender = Gender.MALE;

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "mynt2407@gmail.com";
		account2.userName = "mynguyen";
		account2.fullName = "Nguyen Thi My";
		account2.position = Position2;
		account2.createDate = new Date(93, 10, 01);
		account2.gender = Gender.UNKNOW;

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "tongnhung@gmail.com";
		account3.userName = "nhung.tong";
		account3.fullName = "Tong Thi Nhung";
		account3.position = Position1;
		account3.createDate = new Date(91, 0, 12);
		account3.gender = Gender.FEMALE;

		Account[] accounts = { account1, account2, account3 };
		// xet xem account1 thuoc group nao

		GroupAccount groupaccount1 = new GroupAccount();
		groupaccount1.groups = group2;
		groupaccount1.accounts = account1;
		groupaccount1.joinDate = new Date(90, 11, 20);

		GroupAccount groupaccount2 = new GroupAccount();
		groupaccount2.groups = group1;
		groupaccount2.accounts = account1;
		groupaccount2.joinDate = new Date(89, 01, 22);

		GroupAccount[] groupOfAccount1 = { groupaccount2, groupaccount1 };
		account1.groups = groupOfAccount1;

//		number();
//		name();
//		birthDay();
//		get_account(positions);
		question9(accounts,groups);
//		question6();
//		question8();
	}

	// number
	public static void number() {

		// Question 1:
		// Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình

		// Cach 1: dung ham for
//
		Scanner input_number = new Scanner(System.in);
//		int[] numbers = { 1, 10, 30 }; /// int [] numbers = new int[3];
//		System.out.println("Moi ban nhap vao 3 so nguyen");
//
//		for (int i = 0; i < 3; i++) {
//			int x = input_number.nextInt();
//			System.out.println("Moi ban nhap vao so thu:" + (x + 1));
//			numbers[i] = input_number.nextInt();
//		}
//		System.out.println(" Cac so ban vua nhap la: ");
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.println("Ban vua nhap vao: ");
//
//		}
//
////		// cach 2: nhap thong thuong
//		int a1 = input_number.nextInt();
//		System.out.println("\nSo nguyen thu 1 la:" + a1);
//		int a2 = input_number.nextInt();
//		System.out.println("\nSo nguyen thu 2 la:" + a2);
//		int a3 = input_number.nextInt();
//		System.out.println("\nSo nguyen thu 3 la:" + a3);
//		System.out.println("\nDay so vua nhap la: " + a1 + " " + a2 + " " + " " + a3);
//
////			Question 2: Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình	
//
//		float f1 = input_number.nextFloat();
//		System.out.println("\nBan vua nhap vao so thuc:" + f1);
//		float f2 = input_number.nextFloat();
//		System.out.println("\nBan vua nhap vao so thuc:" + f2);
//		Question 7:
//		Nhập số chẵn từ console
		System.out.println("moi ban nhap vao so chan: ");
		int so_chan = input_number.nextInt();
		if (so_chan % 2 != 0) {
			System.out.println("So ban vua nhap khong phai so chan. Moi ban nhap lai!");
		} else if (so_chan % 2 == 0) {
			System.out.println("So chan ban vua nhap la: " + so_chan);
		}
	}

//		Question 8:
//			Viết chương trình thực hiện theo flow sau:
//			Bước 1:
//			Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
//			Bước 2:
//			Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
//			Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo department
//			Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập
//			lại" và quay trở lại bước 1

	public static void question8() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao chuc nang muon su dung: ");
		int nhap_so = scanner.nextInt();

		switch (nhap_so) {
		case 1:
			inputAccount();

			break;
		case 2:
			inputDepartment();
			break;
		default:
			System.out.println("Ban chi duoc nhap 1 hoac 2. Moi ban nhap lai!");
			break;
		}
	}

	private static void inputDepartment() {
		Scanner scanner = new Scanner(System.in);

		Department department = new Department();
		System.out.println("Moi ban tao department!");

		System.out.print("id la: ");
		int id = scanner.nextInt();
		department.id = (byte) id;

		scanner.nextLine();
		System.out.print("Ten department la: ");
		String name = scanner.nextLine();
		department.name = name;
		System.out.println("\n");

		System.out.println("Ban da tao thanh cong department!");
		System.out.println("id department: " + id);
		System.out.println("Ten department: " + name);

	}

	private static void inputAccount() {
		Scanner scanner = new Scanner(System.in);

		Account account = new Account();
		System.out.println("Moi ban tao account!");

		System.out.print("id la: ");
		int id = scanner.nextInt();
		account.id = (byte) id;

		scanner.nextLine();
		System.out.print("Ten account la: ");
		String name = scanner.nextLine();
		account.name = name;
		System.out.println("\n");

		System.out.println("Ban da tao thanh cong account!");
		System.out.println("id account: " + id);
		System.out.println("Ten account: " + name);

	}

	/// Birthday
	public static void birthDay() throws ParseException {

		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ngay sinh: ");
		String dateInput = scanner1.next();

		String pattern = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date birthday = dateFormat.parse(dateInput);
		System.out.println("Ngay sinh cua ban la:" + birthday);

	}

	/// name
	public static void name() {
		Scanner input = new Scanner(System.in);

		// Question 3: Viết lệnh cho phép người dùng nhập họ và tên

		// Nhap vao ho:

		String lastName = input.nextLine();
		boolean hasNumber = false;
		for (int i = 0; i < lastName.length(); i++) {
			if (Character.isDigit(lastName.charAt(i)) == true) {
				hasNumber = true;
				break;
			}
		}

		if (hasNumber == true) {
			System.out.println("Chuỗi bạn vừa nhập chứa kí tự số, mời bạn nhập lại!");
		} else if (input.nextLine() == "") {
			System.out.println("Ban chua nhap gi ca! Moi ban nhap lai");
		} else {
			System.out.println("Ho la: " + lastName);
		}

		// Nhap vao ten:

		String firtName = input.nextLine();
		boolean hasNumber1 = false;
		for (int i = 0; i < firtName.length(); i++) {
			if (Character.isDigit(firtName.charAt(i)) == true) {
				hasNumber1 = true;
				break;
			}
		}

		if (hasNumber1 == true) {
			System.out.println("Chuỗi bạn vừa nhập chứa kí tự số, mời bạn nhập lại!");
		}

		else if (input.nextLine() == "") {
			System.out.println("Ban chua nhap gi ca! Moi ban nhap lai");
		} else {

			System.out.println("Ten la: " + firtName);
		}
	}

//	Question 5:
//		Viết lệnh cho phép người dùng tạo account (viết thành method)
//		Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
//		chương trình sẽ chuyển thành Position.Dev, Position.Test,
//		Position.ScrumMaster, Position.PM

	public static void get_account(Position[] positions) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap Username: ");
		String input_account = scanner.next();

		System.out.println("Moi ban nhap email: ");
		String input_email = scanner.next();
		System.out.println("Moi ban nhap vao ID cua phong ban: ");

		for (int i = 0; i < positions.length; i++) {
			int ID_position = scanner.nextInt();
			System.out.println("Phong ban thu " + (i + 1) + " la: " + positions[i].positionName);

		}

	}

//	Question 9:
//		Viết method cho phép người dùng thêm group vào account theo flow sau:
//		Bước 1:
//		In ra tên các usernames của user cho người dùng xem
//		Bước 2:
//		Yêu cầu người dùng nhập vào username của account
//		Bước 3:
//		In ra tên các group cho người dùng xem
//		Bước 4:
//		Yêu cầu người dùng nhập vào tên của group
//		Bước 5:
//		Dựa vào username và tên của group người dùng vừa chọn, hãy
//		thêm account vào group đó .

	public static void question9(Account[] accounts, Group[] groups) {
		Scanner scanner2 = new Scanner(System.in);

		for (int j = 0; j < accounts.length; j++) {
			System.out.println(accounts[j].userName);
		}
		System.out.println("Moi ban nhap username vao: ");
		String input_userName = scanner2.nextLine();

		for (int i = 0; i < groups.length; i++) {
			System.out.println(groups[i].groupName);
		}
		System.out.println("Moi ban nhap vao ten group: ");
		String input_group = scanner2.nextLine();

	}

//	Question 6:
//		Viết lệnh cho phép người dùng tạo department (viết thành method)
	public static void question6() {
		Scanner scanner = new Scanner(System.in);

		Department department = new Department();
		System.out.println("Moi ban tao department!");
		// String a = scanner.nextLine();

		System.out.print("Moi ban nhap vao id: ");
		byte id = scanner.nextByte();
		department.id = id;

		scanner.nextLine();
		System.out.print("Moi ban nhap vao ten phong ban: ");
		String name = scanner.nextLine();
		department.name = name;
		System.out.println("\n");

		System.out.println("Id vau tao la: " + id);
		System.out.println("Name cua ban vua tao la: " + name);

	}

}
