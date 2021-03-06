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
			System.out.println("Nh??n vi??n n??y ch??a c?? ph??ng ban");
		} else {
			System.out.println("Ph??ng ban c???a nh??n vi??n n??y l??: " + account2.department.name);
		}
		System.out.println("\n");

		// Question 2
		if (account2.groups == null) {
			System.out.println("Nh??n vi??n n??y ch??a c?? group");
		} else if (account2.groups.length == 1 || account2.groups.length == 2) {
			System.out.println("Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher");
		} else if (account2.groups.length == 3) {
			System.out.println("Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group");
		} else {
			System.out.println("Nh??n vi??n n??y l?? ng?????i h??ng chuy???n, tham gia t???t c??? c??c group");
		}
		System.out.println("\n");

		// Question 3: S??? d???ng to??n t??? ternary ????? l??m Question 1

		System.out.println(account2.department == null ? "Nh??n vi??n n??y ch??a c?? ph??ng ban"
				: "Ph??ng ban c???a nh??n vi??n n??y l??: " + account2.department.name);
		System.out.println("\n");

//	Question 4: S??? d???ng to??n t??? ternary ????? l??m y??u c???u sau:
//		Ki???m tra Position c???a account th??? 1
//		N???u Position = Dev th?? in ra text "????y l?? Developer"
//		N???u kh??ng ph???i th?? in ra text "Ng?????i n??y kh??ng ph???i l?? Developer"

		System.out.println(account1.position.positionName == PositionName.DEV ? "????y l?? Developer"
				: "Ng?????i n??y kh??ng ph???i l?? Developer");
		System.out.println("\n");

		// lay ra CreateDate cua account 1: cach 1, Datatype l?? Date
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

		System.out.println("Hello World"); // c?? ch??? ln ????? xu???ng d??ng
		System.out.println("Hello World");
		System.out.println("\n");

		System.out.printf("%15s %15d %nABC", "Nam", 16);
		System.out.println("\n"); // Format d??? li???u: %s %d l?? bi???n ?????
									// insert "Nam" v?? 16 v??o
									// s??? 15 ????? d??n c??ch
//	SWITCH CASE : chay cung luc nhieu lenh. ko chay lan luot theo thu tu
//	Question 5:
//	L???y ra s??? l?????ng account trong nh??m th??? 1 v?? in ra theo format sau:
//	N???u s??? l?????ng account = 1 th?? in ra "Nh??m c?? m???t th??nh vi??n"
//	N???u s??? l?????ng account = 2 th?? in ra "Nh??m c?? hai th??nh vi??n"
//	N???u s??? l?????ng account = 3 th?? in ra "Nh??m c?? ba th??nh vi??n"
//	C??n l???i in ra "Nh??m c?? nhi???u th??nh vi??n"

//	switch (group1.accounts.length) {
//	case 1:
//		System.out.println("Nh??m c?? m???t th??nh vi??n");
//		break;
//	case 2:
//		System.out.println("Nh??m c?? hai th??nh vi??n");
//		break;
//	case 3:
//		System.out.println("Nh??m c?? ba th??nh vi??n");
//		break;
//	default:
//		System.out.println("Co" + account1.groups.length + "trong nhom" );
//		break;
//	}
//	System.out.println("\n");

////	Question 6:
////	S??? d???ng switch case ????? l??m l???i Question 2
//	Question 2:
//		Ki???m tra account th??? 2
//		N???u kh??ng c?? group th?? s??? in ra text "Nh??n vi??n n??y ch??a c?? group"
//		N???u c?? m???t trong 1 ho???c 2 group th?? s??? in ra text "Group c???a nh??n vi??n
//		n??y l?? Java Fresher, C# Fresher"
//		N???u c?? m???t trong 3 Group th?? s??? in ra text "Nh??n vi??n n??y l?? ng?????i
//		quan tr???ng, tham gia nhi???u group"
//		N???u c?? m???t trong 4 group tr??? l??n th?? s??? in ra text "Nh??n vi??n n??y l??
//		ng?????i h??ng chuy???n, tham gia t???t c??? c??c group"
//
//	switch (account2.groups.length) {
//	case 0:
//		System.out.println("Nh??n vi??n n??y ch??a c?? group");
//		break;
//	case 1:
//		System.out.println("Group c???a nh??n vi??n n??y l??");
//		break;
//	case 2:
//		System.out.println("Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group");
//		break;
//	case 3:
//		System.out.println("Nh??n vi??n n??y l?? ng?????i quan tr???ng");
//		break;
//		
//	default:
//		System.out.println("Account 2 nay co trong" + " " + account2.groups.length + " " + "nhom" );
//		break;
//	}
//	
//	//Question 7: S??? d???ng switch case ????? l??m l???i Question 4

		switch (account1.position.positionName.name()) {
		case "DEV":
			System.out.println("????y l?? Developer");
			break;
		default:
			System.out.println("Ng?????i n??y kh??ng ph???i l?? Developer");
			break;
		}
		System.out.println("\n");

//	FOREACH
//	Question 8:
//	In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng ban c???a h???

		for (Account account : accounts) {
			System.out.println("Email is" + " " + account.email);
			System.out.println("Fullname is" + " " + account.fullName);
			System.out.println("Department_name is" + " " + account.department.name);
			System.out.println("\n");
		}

//	Question 9:
//	In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name
		for (Department a : departments) {
			System.out.println("ID phong ban la" + " " + a.id);
			System.out.println("Ten phong ban la" + " " + a.name);
			System.out.println("\n");
		}

////////	FOR //////////

//	Question 10:
//	In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng ban c???a
//	h??? theo ?????nh d???ng nh?? sau:
//	Th??ng tin account th??? 1 l??:
//	Email: NguyenVanA@gmail.com
//	Full name: Nguy???n V??n A
//	Ph??ng ban: Sale
//	Th??ng tin account th??? 2 l??:
//	Email: NguyenVanB@gmail.com
//	Full name: Nguy???n V??n B
//	Ph??ng ban: Marketting

		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Th??ng tin account th??? " + (i + 1) + " " + "la:");
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
//		In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name theo ?????nh d???ng sau:
//		Th??ng tin department th??? 1 l??:
//		Id: 1
//		Name: Sale
//		Th??ng tin department th??? 2 l??:
//		Id: 2
//		Name: Marketing

		for (int i = 0; i < departments.length; i++) {
			System.out.println("Th??ng tin department th??? " + (i + 1) + " " + "la:");
			System.out.println("ID: " + departments[i].id);
			System.out.println("Name: " + departments[i].name);
			System.out.println("\n");
		}

//	Question 12:
//		Ch??? in ra th??ng tin 2 account ?????u ti??n theo ?????nh d???ng nh?? Question 10

		for (int i = 0; i < 2; i++) {
			System.out.println("Th??ng tin account th??? " + (i + 1) + " la:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full name: " + accounts[i].fullName);
			System.out.println("\n");
		}

//	Question 13:
//		In ra th??ng tin t???t c??? c??c account ngo???i tr??? account th??? 2// dung "CONTINUE"

		for (int i = 0; i < accounts.length; i++) {
			if (i == 1) {
				continue;
			}
			System.out.println("Th??ng tin account th??? " + (i + 1) + " la:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full name: " + accounts[i].fullName);
			System.out.println("\n");
		}

//	Question 14:
//		In ra th??ng tin t???t c??? c??c account c?? id < 4
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
//		In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20 (neu bang 10 thi loai)

		for (int i = 0; i <= 20; i++) {
			if (i == 10) {
				continue;
			} else if (i % 2 == 0) {
				System.out.println("So do la: " + i);
			}
		}

/////////////	WHILE/////////

//	Question 16:
//	L??m l???i c??c Question ??? ph???n FOR b???ng c??ch s??? d???ng WHILE k???t h???p v???i
//	l???nh break, continue

//	Question 10 thuoc cau 16:
//	In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng ban c???a
//	h??? theo ?????nh d???ng nh?? sau:
//	Th??ng tin account th??? 1 l??:
//	Email: NguyenVanA@gmail.com
//	Full name: Nguy???n V??n A
//	Ph??ng ban: Sale

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
//		In ra th??ng tin t???t c??? c??c account ngo???i tr??? account th??? 2// dung "CONTINUE"

		int j = 0;
		while (j < accounts.length) {
			if (j == 1) {
				j = j + 1;
				continue;
			}
			System.out.println("Th??ng tin account th??? " + (j + 1) + " la:");
			System.out.println("Email_n: " + accounts[j].email);
			System.out.println("Full name_n: " + accounts[j].fullName);
			System.out.println("\n");

			j = j + 1;
			System.out.println("\n");
		}

//		CAU 16:
//		Question 15:
//		In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20 (neu bang 10 thi loai)
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
//		L??m l???i c??c Question ??? ph???n FOR b???ng c??ch s??? d???ng DO-WHILE k???t h???p v???i l???nh break, continue

//		Question 11: (Question 17)
//			In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name theo ?????nh d???ng sau:
//			Th??ng tin department th??? 1 l??:
//			Id: 1
//			Name: Sale
//			Th??ng tin department th??? 2 l??:
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

		// Question 14: In ra th??ng tin t???t c??? c??c account c?? id < 4 (Question 17)

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
//			In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20 (neu bang 10 thi bo qua)
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
