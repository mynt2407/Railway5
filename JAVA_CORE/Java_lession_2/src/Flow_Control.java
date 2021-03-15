import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Flow_Control {
	public static void main(String[] args) {

		// create department

		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketing";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "Director";

		Department[] departments = { department1, department2, department3 };
		// Possition

		Position Position1 = new Position();
		Position1.id = 1;
		Position1.positionName = PositionName.SCRUM_MASTER;

		Position Position2 = new Position();
		Position2.id = 2;
		Position2.positionName = PositionName.TEST;

		Position Position3 = new Position();
		Position3.id = 3;
		Position3.positionName = PositionName.PM;

		// create account

		Account account1 = new Account();
		account1.id = 7;
		account1.email = "duynguyen1@gmail.com";
		account1.userName = "duy.nguyenngoc";
		account1.fullName = "Nguyen Ngoc Duy";
		account1.department = department1;
		account1.position = Position1;
		account1.createDate = new Date(95, 11, 20);
		account1.gender = Gender.MALE;

		Account account2 = new Account();
		account2.id = 4;
		account2.email = "mynt2407@gmail.com";
		account2.userName = "mynguyen";
		account2.fullName = "Nguyen Thi My";
		account2.department = department1;
		account2.position = Position2;
		account2.createDate = new Date(93, 10, 01);
		account2.gender = Gender.UNKNOW;

		Account account3 = new Account();
		account3.id = 2;
		account3.email = "tongnhung@gmail.com";
		account3.userName = "nhung.tong";
		account3.fullName = "Tong Thi Nhung";
		account3.department = department3;
		account3.position = Position1;
		account3.createDate = new Date(91, 0, 12);
		account3.gender = Gender.FEMALE;

		Account[] accounts = { account1, account2, account3 };

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

		// xet xem account2 thuoc group nao

		GroupAccount groupaccount1b = new GroupAccount();
		groupaccount1b.groups = group2;
		groupaccount1b.accounts = account2;
		groupaccount1b.joinDate = new Date(80, 01, 12);

		GroupAccount groupaccount2b = new GroupAccount();
		groupaccount2b.groups = group1;
		groupaccount2b.accounts = account2;
		groupaccount2b.joinDate = new Date(95, 04, 02);

		GroupAccount groupaccount3b = new GroupAccount();
		groupaccount3b.groups = group3;
		groupaccount3b.accounts = account2;
		groupaccount3b.joinDate = new Date(120, 05, 01);

		GroupAccount[] groupOfAccount2 = { groupaccount1b, groupaccount2b, groupaccount3b };
		account2.groups = groupOfAccount2;

		// Xet xem group 1 co nhung account nao

		GroupAccount[] account_group1 = { groupaccount2, groupaccount2b };
		group1.accounts = account_group1;

		GroupAccount[] account_group2 = { groupaccount1, groupaccount1b };
		group2.accounts = account_group2;

		GroupAccount[] account_group3 = { groupaccount3b, };
		group3.accounts = account_group3;

		// Question 1

		if (account2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là: " + account2.department.name);
		}
		System.out.println("\n");

		// Question 2
		if (account2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else if (account2.groups.length == 1 || account2.groups.length == 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		} else if (account2.groups.length == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
		System.out.println("\n");

		// Question 3: Sử dụng toán tử ternary để làm Question 1

		System.out.println(account2.department == null ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là: " + account2.department.name);
		System.out.println("\n");

//	Question 4: Sử dụng toán tử ternary để làm yêu cầu sau:
//		Kiểm tra Position của account thứ 1
//		Nếu Position = Dev thì in ra text "Đây là Developer"
//		Nếu không phải thì in ra text "Người này không phải là Developer"

		System.out.println(account1.position.positionName == PositionName.DEV ? "Đây là Developer"
				: "Người này không phải là Developer");
		System.out.println("\n");

		// lay ra CreateDate cua account 1: cach 1, Datatype là Date
		System.out.println(account1.createDate);
		Locale locale = new Locale("vi", "VN");
		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

		String date = dateformat.format(account1.createDate);
		System.out.println(date);
		System.out.println("\n");

		// lay ra CreateDate cua account 1: cach 2 (pattern)
		System.out.println(account2.createDate);
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date1 = simpleDateFormat.format(account2.createDate);
		System.out.println(date1);
		System.out.println("\n");

		System.out.println("Hello World"); // có chữ ln để xuống dòng
		System.out.println("Hello World");
		System.out.println("\n");

		System.out.printf("%15s %15d %nABC", "Nam", 16);
		System.out.println("\n"); // Format dữ liệu: %s %d là biến để
									// insert "Nam" và 16 vào
									// số 15 để dãn cách
//	SWITCH CASE : chay cung luc nhieu lenh. ko chay lan luot theo thu tu
//	Question 5:
//	Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//	Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//	Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//	Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//	Còn lại in ra "Nhóm có nhiều thành viên"

//	switch (group1.accounts.length) {
//	case 1:
//		System.out.println("Nhóm có một thành viên");
//		break;
//	case 2:
//		System.out.println("Nhóm có hai thành viên");
//		break;
//	case 3:
//		System.out.println("Nhóm có ba thành viên");
//		break;
//	default:
//		System.out.println("Co" + account1.groups.length + "trong nhom" );
//		break;
//	}
//	System.out.println("\n");

////	Question 6:
////	Sử dụng switch case để làm lại Question 2
//	Question 2:
//		Kiểm tra account thứ 2
//		Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//		Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên
//		này là Java Fresher, C# Fresher"
//		Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
//		quan trọng, tham gia nhiều group"
//		Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
//		người hóng chuyện, tham gia tất cả các group"
//
//	switch (account2.groups.length) {
//	case 0:
//		System.out.println("Nhân viên này chưa có group");
//		break;
//	case 1:
//		System.out.println("Group của nhân viên này là");
//		break;
//	case 2:
//		System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
//		break;
//	case 3:
//		System.out.println("Nhân viên này là người quan trọng");
//		break;
//		
//	default:
//		System.out.println("Account 2 nay co trong" + " " + account2.groups.length + " " + "nhom" );
//		break;
//	}
//	
//	//Question 7: Sử dụng switch case để làm lại Question 4

		switch (account1.position.positionName.name()) {
		case "DEV":
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
			break;
		}
		System.out.println("\n");

//	FOREACH
//	Question 8:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ

		for (Account account : accounts) {
			System.out.println("Email is" + " " + account.email);
			System.out.println("Fullname is" + " " + account.fullName);
			System.out.println("Department_name is" + " " + account.department.name);
			System.out.println("\n");
		}

//	Question 9:
//	In ra thông tin các phòng ban bao gồm: id và name
		for (Department a : departments) {
			System.out.println("ID phong ban la" + " " + a.id);
			System.out.println("Ten phong ban la" + " " + a.name);
			System.out.println("\n");
		}

////////	FOR //////////

//	Question 10:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//	họ theo định dạng như sau:
//	Thông tin account thứ 1 là:
//	Email: NguyenVanA@gmail.com
//	Full name: Nguyễn Văn A
//	Phòng ban: Sale
//	Thông tin account thứ 2 là:
//	Email: NguyenVanB@gmail.com
//	Full name: Nguyễn Văn B
//	Phòng ban: Marketting

		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " " + "la:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full name: " + accounts[i].fullName);
			if (accounts[i].department != null) {
				System.out.println("Phong ban: " + accounts[i].department.name);
			} else {
				System.out.println("Khong co phong ban nao");
			}
			System.out.println("\n");
		}

//	Question 11:
//		In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//		Thông tin department thứ 1 là:
//		Id: 1
//		Name: Sale
//		Thông tin department thứ 2 là:
//		Id: 2
//		Name: Marketing

		for (int i = 0; i < departments.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " " + "la:");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			System.out.println("\n");
		}

//	Question 12:
//		Chỉ in ra thông tin 2 account đầu tiên theo định dạng như Question 10

		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " la:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full name: " + accounts[i].fullName);
			System.out.println("\n");
		}

//	Question 13:
//		In ra thông tin tất cả các account ngoại trừ account thứ 2// dung "CONTINUE"

		for (int i = 0; i < accounts.length; i++) {
			if (i == 1) {
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " la:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full name: " + accounts[i].fullName);
			System.out.println("\n");
		}

//	Question 14:
//		In ra thông tin tất cả các account có id < 4
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].id < 4) {
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full name: " + accounts[i].fullName);
				System.out.println("\n");
			} else {
				System.out.println("Khong co account nao");
			}
		}

//	Question 15:
//		In ra các số chẵn nhỏ hơn hoặc bằng 20 (neu bang 10 thi loai)

		for (int i = 0; i <= 20; i++) {
			if (i == 10) {
				continue;
			} else if (i % 2 == 0) {
				System.out.println("So do la: " + i);
			}
		}

/////////////	WHILE/////////

//	Question 16:
//	Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với
//	lệnh break, continue

//	Question 10 thuoc cau 16:
//	In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//	họ theo định dạng như sau:
//	Thông tin account thứ 1 là:
//	Email: NguyenVanA@gmail.com
//	Full name: Nguyễn Văn A
//	Phòng ban: Sale

		int i = 0;
		while (i < accounts.length) {
			System.out.println("Thong tin account thu: " + (i + 1));
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullName);
			i = i + 1;
			System.out.println("\n");
		}
//
//	CAU 16: 
//		Question 13:
//		In ra thông tin tất cả các account ngoại trừ account thứ 2// dung "CONTINUE"

		int j = 0;
		while (j < accounts.length) {
			if (j == 1) {
				j = j + 1;
				continue;
			}
			System.out.println("Thông tin account thứ " + (j + 1) + " la:");
			System.out.println("Email_n: " + accounts[j].email);
			System.out.println("Full name_n: " + accounts[j].fullName);
			System.out.println("\n");

			j = j + 1;
			System.out.println("\n");
		}

//		CAU 16:
//		Question 15:
//		In ra các số chẵn nhỏ hơn hoặc bằng 20 (neu bang 10 thi loai)
		int k = 0;
		while (k <= 20) {

			if (k == 10) {
				k = k + 1;
				continue;
			} else if (k % 2 == 0) {
				System.out.println("So can in ra la: " + k);
			}
			k = k + 1;
		}

/////////DO-WHILE///////////////////
//		Question 17:
//		Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với lệnh break, continue

//		Question 11: (Question 17)
//			In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//			Thông tin department thứ 1 là:
//			Id: 1
//			Name: Sale
//			Thông tin department thứ 2 là:
//			Id: 2
//			Name: Marketing

		int m = 0;
		do {
			System.out.println("DW Thong tin cua phong ban thu " + (m + 1) + " la: ");
			System.out.println("Id: " + departments[m].id);
			System.out.println("Name: " + departments[m].name);
			m = m + 1;
			System.out.println("\n");
		} while (m < departments.length);

		// Question 14: In ra thông tin tất cả các account có id < 4 (Question 17)

		int n = 0;
		do {
			if (accounts[n].id < 4) {
				System.out.println("DW Id cua account: " + accounts[n].id);
				System.out.println("Ten account: " + accounts[n].fullName);
				System.out.println("Email account: " + accounts[n].email);
			}
			n = n + 1;
		} while (n < accounts.length);

//		Question 15 (Question 17)
//			In ra các số chẵn nhỏ hơn hoặc bằng 20 (neu bang 10 thi bo qua)
		int a = 0;
		do {
			if (a == 10) {
				a = a + 1;
				continue;
			} else if (a % 2 == 0) {
				System.out.println("a: " + a);
			}
			a = a + 1;

		} while (a <= 20);

	}
}
