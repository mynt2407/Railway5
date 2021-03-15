import java.util.Scanner;

public class Exercise_2 {
	public static void main(String[] args) {
//	Question 1:
//		Nhập số liệu cho dãy số thực a0 , a1 ,..., an-1 .
//		Hãy liệt kê các phần tử xuất hiện trong dãy đúng một lần

//		question1();
//		question2();
//		question3();
		question4();
//		question5();
//		question6();
	}

	public static void question1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ban muon nhap bao nhieu so? ");
		int n = scanner.nextInt();

		float[] numbers = new float[n];
		for (int i = 0; i < numbers.length; i++) {
			System.out.print("So thu " + (i + 1) + " la: ");
			numbers[i] = scanner.nextFloat();
		}

		for (int k = 0; k < numbers.length; k++) {

			float element = numbers[k];
			boolean isSame = false;
			
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[j] == element && j != k) {
					isSame = true;
					break;
				}
			}
			if (!isSame) {
				System.out.println(element);
			}
		}
	}

//	Question 2:
//		Nhập số liệu cho dãy số thực a0 , a1 ,..., an-1.
//		Hãy liệt kê các phần tử xuất hiện trong dãy đúng 2 lần.

	public static void question2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ban muon in ra may so thuc? ");
		int n1 = scanner.nextInt();

		float[] f1 = new float[n1];

		for (int i = 0; i < f1.length; i++) {
			System.out.println("So thuc thu " + (i + 1) + " la: ");
			f1[i] = scanner.nextFloat();
		}

		for (int k = 0; k < f1.length; k++) {

			float element = f1[k];
			int count = 1;
			for (int j = 0; j < f1.length; j++) {
				if (f1[j] == element && j != k) {
					count++;
				}
			}

			if (count == 2) {
				System.out.println(element);
			}

		}
	}
//		Question 3:
//			Nhập số liệu cho dãy số thực a0 , a1 ,..., an-1 .
//			In ra màn hình số lần xuất hiện của các phần tử

	public static void question3() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("How many numbers do you wanna input? ");
		int n2 = scanner.nextInt();

		float[] f2 = new float[n2];

		for (int a = 0; a < f2.length; a++) {
			System.out.println("So thuc thu " + (a + 1) + " la: ");
			f2[a] = scanner.nextFloat();
		}
		for (int b = 0; b < f2.length; b++) {

			float element1 = f2[b];
			int count1 = 1;
			for (int c = 0; c < f2.length; c++) {
				if (f2[c] == element1 && c != b) {
					count1++;
				}
			}
			System.out.println("So lan xuat hien cua phan tu thu " + (b + 1) + " la:" + count1++);
		}

	}

//	Question 4:
//		Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ.
//		Ví dụ: Số 8545604 có tổng các chữ số là: 8+5+4+5+6+0+4= 32

	public static void question4() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao mot so nguyen bat ky: ");
		int soNguyen = scanner.nextInt();

		String a = soNguyen + "";

		System.out.println("Day nay co " + a.length() + " chu so");

		// 4: (soNguyen % 10) / 1
		// 0: (soNguyen % 100) / 10
		// 6: (soNguyen % 1000) / 100

		int sum = 0;
		for (int j = 0; j < a.length(); j++) {
			int a1 = (int) Math.pow(10, j + 1);
			System.out.println("a la " + a1);
			int b1 = (int) Math.pow(10, j);
			System.out.println("b la " +b1);
			
			int element = (soNguyen % a1) / b1;

			sum += element;
		}

		System.out.println(sum);

	}

//	Question 5:
//		Viết chương trình phân tích một số nguyên thành các thừa số nguyên tố
//		Ví dụ: Số 28 được phân tích thành 2 x 2 x 7

	public static void question5() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao mot so nguyen bat ky: ");
		int number = scanner.nextInt();

		int[] thuaSo = new int[number];
	//	int a = number/thuaSo;

	}

//	Question 6:
//		Viết chương trình liệt kê tất cả các số nguyên tố nhỏ hơn n cho trước.

	public static void question6() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao so: ");
		int soNguyen = scanner.nextInt();
		for (int i = 0; i < soNguyen; i++) {
			System.out.println(i);
		}
	}

}
