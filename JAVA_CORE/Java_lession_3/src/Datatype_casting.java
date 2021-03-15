import java.util.Random;

public class Datatype_casting {

	public static void main(String[] args) {
//		question1();
		question2();
//		question3();
//		question4();

	}

//	Question 1:
//		Khai báo 2 số lương có kiểu dữ liệu là float.
//		Khởi tạo Lương của Account 1 là 5240.5 $
//		Khởi tạo Lương của Account 2 là 10970.055$
//		Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//		Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra

	public static void question1() {

		float l1 = (float) 5240.5;
		float l2 = (float) 10970.055;

		int l3 = (int) l1;
		int l4 = (int) l2;

		System.out.println(l3);
		System.out.println(l4);

// Lam them:

		String l5 = l1 + "";
		System.out.println(l5);

		int a = 3;
		float a1 = a;
		int b = 2;
		int c = (int) (a1 / b);
		System.out.println(c);
	}

//Question 2:
//Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
//con số 0 ở đầu cho đủ 5 chữ số)

	public static void question2() {
		
		Random random = new Random();
		int x = random.nextInt(99999 - 0 + 1) + 0;
		System.out.println(x);
		
		String y = String.valueOf(x); // String y = x + "";
		System.out.println("Do dai cua so do la: " + y.length());
		switch (y.length()) {
		case 1:
			System.out.println("0000" + y);
			break;
		case 2:
			System.out.println("000" + y);
			break;
		case 3:
			System.out.println("00" + y);
			break;
		case 4:
			System.out.println("0" + y);
			break;
		default:
			System.out.println(y);
			break;
		}

	}

//Question 3:
//Lấy 2 số cuối của số ở Question 2 và in ra.
//Gợi ý:
//Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
//Cách 2: chia lấy dư số đó cho 100

	public static void question3() {
		// Cach 1:
		short a = 12345;
		short b = (short) (a % 100);
		System.out.println(b);

	}

//Question 4:
//Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
	public static void question4() {
		int a = 7;
		int b = 3;
		float c = (float) a / b;
		System.out.println(c);

	}

}
