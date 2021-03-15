import java.util.Scanner;

public class String_exercise {
	public static void main(String[] args) {

//		question1();
//		question2();
//		question3();
//		question4();
//		question5();
//		question6();
//		question7();
//		question8();
//		question9();
//		question10();
		question11();
//		question12();
//		question13();
//		question14();
//		question15();
//		question16();
	}

	public static void question1() {
//	Question 1:
//		Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
//		thể cách nhau bằng nhiều khoảng trắng );

		String kiTu = "    Toi la    abcd    ";

		// cach 1:
		int spaceCount = 0;
		String a = kiTu.trim();
		a = a.replaceAll("\\s+", " ");
		String[] words = a.split("\\s");
		int count = 0;
		System.out.println("Do dai " + words.length );

	}

	public static void question2() {

//	Question 2:
//		Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi ban nhap vao xau ki tu S1: ");
		String s1 = scanner.nextLine();

		System.out.print("Moi ban nhap vao xau ki tu S2: ");
		String s2 = scanner.nextLine();
		System.out.println(s1 + " " + s2);
	}

//	Question 3:
//		Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
//		viết hoa chữ cái đầu thì viết hoa lên
	public static void question3() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("moi ban nhap vao ten cua minh: ");
		String name = scanner.nextLine();
		System.out.println(name.toUpperCase());
	}

//Question 4:
//  Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của người dùng ra
//VD:
// Người dùng nhập vào "Nam", hệ thống sẽ in ra
// "Ký tự thứ 1 là: N"
// "Ký tự thứ 1 là: A"
// "Ký tự thứ 1 là: M" 
	public static void question4() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi ban nhap vao ten: ");
		String name = scanner.nextLine();
		for (int i = 0; i < name.length(); i++) {
			System.out.println(name.toUpperCase().charAt(i));

		}
	}

//	Question 5:
//		Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
//		dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
	public static void question5() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi ban nhap vao ho: ");
		String ho = scanner.nextLine();

		System.out.print("Moi ban nhap vao ten: ");
		String ten = scanner.nextLine();
		System.out.println("Ho va ten cua ban la: " + ho + " " + ten);
	}

//	Question 6:
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//		sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//		VD:
//		Người dùng nhập vào "Nguyễn Văn Nam"
//		Hệ thống sẽ in ra
//		"Họ là: Nguyễn"
//		"Tên đệm là: Văn"
//		"Tên là: Nam"
	public static void question6() {

		String fullname;
		String firstName = "";
		String lastName = "";
		String middleName = "";

		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi ban nhap vao ho ten day du: ");
		fullname = scanner.nextLine();

		fullname = fullname.replaceAll("\\s+", " ");

		String[] fullname2 = fullname.split(" ");

		lastName = fullname2[0];
		firstName = fullname2[fullname2.length - 1];

		for (int i = 1; i < fullname2.length - 1; i++) {
			middleName += fullname2[i] + " ";
		}
		System.out.println("Ho la: " + lastName);
		System.out.println("Ten dem la: " + middleName);
		System.out.println("Ten la: " + firstName);
	}
//	Question 7:
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//		chuẩn hóa họ và tên của họ như sau:
//		a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//		chuẩn hóa thành "nguyễn văn nam"
//		b) Viết hoa chữ cái mỗi từ của người dùng
//		VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
//		chuẩn hóa thành "Nguyễn Văn Nam"

	public static void question7() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi ban nhap vao ho va ten: ");
		String input = scanner.nextLine();
		input = input.trim();
		input = input.replaceAll("\\s+", " ");

		String[] words = input.split(" ");
		input = "";
		for (String word : words) {

			String firstCharacter = word.substring(0, 1).toUpperCase();
			String leftCharacter = word.substring(1);
			word = firstCharacter + leftCharacter;
			input += word + " ";

		}
		System.out.println("Ho ten sau khi chuan hoa: " + input);
	}

//	Question 8:
//		In ra tất cả các group có chứa chữ "Java"
	public static void question8() {
		// create group
		Group group1 = new Group();
		group1.id = 1;
		group1.groupName = "Nhom Java Fresher";

		Group group2 = new Group();
		group2.id = 2;
		group2.groupName = "Nhom C# Fresher, Java";

		Group group3 = new Group();
		group3.id = 3;
		group3.groupName = "Nhom PHP Fresher";
		Group[] groups = { group1, group2, group3 };

		for (int i = 0; i < groups.length; i++) {
			if (groups[i].groupName.contains("Java")) {
				System.out.println(groups[i].groupName);
			}

		}

	}

	// Question 9: In ra tất cả các group "Java"
	public static void question9() {
		// create group
		Group group1 = new Group();
		group1.id = 1;
		group1.groupName = "Nhom Java Fresher";

		Group group2 = new Group();
		group2.id = 2;
		group2.groupName = "Java";

		Group group3 = new Group();
		group3.id = 3;
		group3.groupName = "Nhom PHP Fresher";
		Group[] groups = { group1, group2, group3 };

		for (int i = 0; i < groups.length; i++) {
			if (groups[i].groupName.equals("Java")) {
				System.out.println("ID: " + groups[i].id);
				System.out.println("Name: " + groups[i].groupName);
			}
		}

	}

//	Question 10 (Optional):
//		Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
//		Nếu có xuất ra “OK” ngược lại “KO”.
//		Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau
	public static void question10() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi ban nhap vao chuoi thu 1: ");
		String input1 = scanner.nextLine();

		System.out.print("Moi ban nhap vao chuoi thu 2: ");
		String input2 = scanner.nextLine();

		String reverse = "";

		for (int i = input2.length() - 1; i >= 0; i--) {
			reverse = reverse + input2.charAt(i);
		}
		if (input1.equals(reverse)) {
			System.out.println("Hai chuoi tren la chuoi dao nguoc cua nhau");
		} else {
			System.out.println("Hai chuoi tren khong la dao nguoc cua nhau");
		}

	}

//	Question 11 (Optional): Count special Character
//	Tìm số lần xuất hiện ký tự "a" trong chuỗi

	public static void question11() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi ban nhap vao mot chuoi: ");
		String input = scanner.nextLine();

		int count = 0;
		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == 'a') {
				count++;
			}
		}
		System.out.println("Ki tu a xuat hien " + count + " lan");
	}
//	Question 12 (Optional): Reverse String
//	Đảo ngược chuỗi sử dụng vòng lặp

	public static void question12() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi ban nhap vao chuoi bat ky: ");
		String input = scanner.nextLine();

		String reverse = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reverse = reverse + input.charAt(i);
		}
		System.out.print("Chuoi dao nguoc la: " + reverse);
	}

//	Question 13 (Optional): String not contains digit
//	Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược
//	lại true.
//	Ví dụ:
//	"abc" => true
//	"1abc", "abc1", "123", "a1bc", null => false

	public static void question13() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("moi ban nhap vao mot chuoi khong co so: ");
		String input = scanner.nextLine();
		boolean containsDigit = false;

		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i)) == true) {
				containsDigit = true;
				break;

			}
		}
		if (containsDigit == true) {
			System.out.println("Chuoi nay chua ki tu so. Moi ban nhap lai!");
		} else {
			System.out.println("Chuoi ban vua nhap la: " + input);

		}
	}

//	Question 14 (Optional): Replace character
//	Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác
//	cho trước.
//	Ví dụ:
//	"VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"
	public static void question14() {

		String string = "mymynguyen";
		String string1 = string.replace("m", "*");
		System.out.println(string1);
	}

//	Question 15 (Optional): Revert string by word thư viện.
//	Ví dụ: " I am developer " => "developer am I".
//	Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
//	Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt chuỗi theo dấu cách

	public static void question15() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("moi ban nhap vao mot chuoi ki tu: ");
		String input = scanner.nextLine();

		input = input.trim();
		input = input.replaceAll("\\s+", " ");
		String reverse = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reverse = reverse + input.charAt(i);
		}
		System.out.println("Chuoi dao nguoc la: " + reverse);
	}
//	Question 16 (Optional):
//		Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần
//		bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn hình “KO”

	public static void question16() {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Moi ban nhap vao 1 chuoi bat ki: ");
		String inputS = scanner.nextLine();
		inputS = inputS.replaceAll("\\s+", "");
		inputS = inputS.trim();

		System.out.print("Moi ban nhap vao so nguyen bat ki: ");
		int ints = scanner.nextInt();

		int x = inputS.length() % ints;
		if (x != 0) {
			System.out.println("KO!");
		} else {
			System.out.println("Chuoi nay duoc chia thanh " + inputS.length() / ints + " bang nhau");
		}

	}
}