import java.util.Date;

public class InClass_lession2 {
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

		// create account

		Account account1 = new Account();
		account1.id = 1;
		account1.email = "duynguyen1@gmail.com";
		account1.userName = "duy.nguyenngoc";
		account1.fullName = "Nguyen Ngoc Duy";
		account1.department = department1;
		account1.position = Position1;
		account1.createDate = new Date(95, 11, 20);
		account1.gender = Gender.MALE;

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "mynt2407@gmail.com";
		account2.userName = "mynguyen";
		account2.fullName = "Nguyen Thi My";
		account2.department = department1;
		account2.position = Position2;
		account2.createDate = new Date(93, 10, 01);
		account2.gender = Gender.UNKNOW;

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "tongnhung@gmail.com";
		account3.userName = "nhung.tong";
		account3.fullName = "Tong Thi Nhung";
		account3.department = department3;
		account3.position = Position1;
		account3.createDate = new Date(91, 0, 12);
		account3.gender = Gender.FEMALE;

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

		if (department1.id == 1 && department1.name.equals("Marketing")) {
			System.out.println("Day la phong ban dau tien");
		} else {
			System.out.println("Day khong phai la phong dau tien" + department1.name.equals("Sale"));

		}
		switch (account1.groups.length) {
		case 1:
			System.out.println("Co 1 group");
			break;
		case 2:
			System.out.println("Co 2 group");
			break;

		default:
			System.out.println("Co" + account1.groups.length + "group");
			break;
		}
		System.out.println("\n");

//		Question 10:
//			In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//			họ theo định dạng như sau:
//			Thông tin account thứ 1 là:
//			Email: NguyenVanA@gmail.com
//			Full name: Nguyễn Văn A
//			Phòng ban: Sale
//			Thông tin account thứ 2 là:
//			Email: NguyenVanB@gmail.com
//			Full name: Nguyễn Văn B
//			Phòng ban: Marketting

		for (int i = 0; i < groupOfAccount1.length; i = i + 1) {
			System.out.println("Thong tin cua group thu" + (i + 1) + "la");
			System.out.println(groupOfAccount1[i].groups.createDate);
			System.out.println(groupOfAccount1[i].groups.id);
		}

	}
}
