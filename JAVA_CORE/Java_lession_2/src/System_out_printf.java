import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class System_out_printf {
	public static void main(String[] args) throws ParseException {
		// create account

		Account account1 = new Account();
		account1.id = 1;
		account1.email = "duynguyen1@gmail.com";
		account1.userName = "duy.nguyenngoc";
		account1.fullName = "Nguyen Ngoc Duy";
		account1.createDate = new Date(95, 11, 20);
		account1.gender = Gender.MALE;

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "mynt2407@gmail.com";
		account2.userName = "mynguyen";
		account2.fullName = "Nguyen Thi My";
		account2.createDate = new Date(93, 10, 01);
		account2.gender = Gender.UNKNOW;

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "tongnhung@gmail.com";
		account3.userName = "nhung.tong";
		account3.fullName = "Tong Thi Nhung";
		account3.createDate = new Date(91, 0, 12);
		account3.gender = Gender.FEMALE;
		
		Account [] accounts = { account1, account2, account3};

//	Question 1:
//		Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó

		int n = 5;
		System.out.printf("%d", n);
		System.out.println("\n");

//	Question 2:
//		Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
//		ra số nguyên đó thành định dạng như sau: 100,000,000

		int a = 100000000;
		System.out.printf(Locale.US, "%,d", a);
		System.out.println("\n");

//	Question 3:
//		Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
//		thực đó chỉ bao gồm 4 số đằng sau

		float b = (float) 5.567098;
		System.out.printf("'%.4f'%n", b);
		System.out.println("\n");

//	Question 4:
//		Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
//		dạng như sau:
//		Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
//		Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.

		String name = "Nguyen Van A";
		System.out.printf("%s %n", "Tên tôi là " + name + " và tôi đang độc thân");
		System.out.println("\n");

//	Question 5:
//		Lấy thời gian bây giờ và in ra theo định dạng sau: 24/04/2020 11h:16p:20s 

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(format.format(date));
		System.out.println("\n");

//	Question 6:
//		In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
//table (giống trong Database)
		System.out.printf("%-30s %-30s %-30s \n", "Id", "Fullname", "Email" );
		System.out.printf("%-30d %-30s %-30s \n" , account1.id , account1.fullName , account1.email);
		System.out.printf("%-30d %-30s %-30s \n" , account2.id , account2.fullName , account2.email);
		System.out.printf("%-30d %-30s %-30s \n" , account3.id , account3.fullName , account3.email);
		

//Vi du:

		Scanner input = new Scanner(System.in);

		System.out.print("Moi ban nhap vao mot so: ");
		int m = input.nextInt();
		System.out.println("\nBan vua nhap vao so:" + m);


	}
	
	
}