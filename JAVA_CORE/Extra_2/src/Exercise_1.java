import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Exercise_1 {
	public static void main(String[] args) {

//	Question 1:
//		Viết chương trình nhập vào một số thực. Đơn vị tính cho số này là centimet (cm).
//		Hãy in ra số tương đương tính bằng foot (số thực, có 2 số lẻ thập phân) và inch
//		(số thực, có 2 số lẻ thập phân).
//		Với 1 inch = 2.54 cm và 1 foot = 12 inches

//	soThuc();
	convertToHour();
	soNguyen();
//	tinhHieu();
//	checkPhanDu();
//		xepLoai();

	}

	public static void soThuc() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao so thuc: ");
		float f1 = scanner.nextFloat();
		float i = f1 / 2.54f;
		float j = f1 / 2.54f * 12f;
		System.out.println("Tuong ung: " + i + " inch");
		System.out.println("Tuong ung: " + j + " foot");
		System.out.println("\n");
	}

//	Question 2:
//		Viết chương trình nhập vào số giây từ 0 tới 68399, đổi số giây này thành dạng
//		[giờ:phút:giây], mỗi thành phần là một số nguyên có 2 chữ số. 
//      Ví dụ: 02:11:05
	public static void convertToHour() {

		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Moi ban nhap vao so giay: ");
		int input_number = scanner1.nextInt();

		int h = input_number / 3600;
		int m = (input_number % 3600) / 60;
		int s = (input_number % 3600) % 60;

		System.out.print(h + ":");
		System.out.print(m + ":");
		System.out.print(s);
	}

//		Question 3:
//			Viết chương trình nhập vào 4 số nguyên.
//			Hiển thị ra số lớn nhất và nhỏ nhất
//			Ví dụ:
//			nhập vào 4 số 1,2,3,4 thì kết quả là:
//			Số lớn nhất là: 4
//			Số nhỏ nhất là: 1

	public static void soNguyen() {

		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Moi ban nhap vao 4 so nguyen: ");
		int[] numbers = new int[4];
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Moi ban nhap so thu " + (i + 1) + " la: ");
			numbers[i] = scanner2.nextInt();
		}
		
		int max = numbers[0];
		int min = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i]; // khong duoc viet nguoc lai.
			}
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}
		System.out.println(" so lon nhat la: " + max);
		System.out.println(" so nho nhat la: " + min);

	}

//	Question 4:
//		Nhập vào hai số tự nhiên a và b. Tính hiệu của hai số đó.
//		Nếu hiệu số lớn hơn 0 thì in ra dòng chữ [Số thứ nhất lớn hơn số thứ hai].
//		Nếu hiệu số nhỏ hơn 0 thì in ra dòng chữ [Số thứ nhất nhỏ hơn số thứ hai].

	public static void tinhHieu() {

		Scanner scanner3 = new Scanner(System.in);
		System.out.print("Moi ban nhap vao so tu nhien a: ");
		int a = scanner3.nextInt();
		System.out.print("Moi ban nhap vao so tu nhien b: ");
		int b = scanner3.nextInt();
		int x = a - b;
		if (x > 0) {
			System.out.println("So thu nhat lon hon so thu hai");
		}
		if (x < 0) {
			System.out.println("So thu nhat nho hon so thu hai");
		}
	}

	// Question 5: Nhập vào 2 số tự nhiên a và b. Kiểm tra xem a có chia hết cho b
	// không

	public static void checkPhanDu() {
		Scanner scanner4 = new Scanner(System.in);
		System.out.print("Moi ban nhap vao so tu nhien a: ");
		int a = scanner4.nextInt();
		System.out.print("Moi ban nhap vao so tu nhien b: ");
		int b = scanner4.nextInt();
		int x = a % b;
		if (x == 0) {
			System.out.println("a chia het cho b");
		}
		if (x != 0) {
			System.out.println("a khong chia het cho b");
		}

	}

//	Question 6:
//		Xếp loại sinh viên theo các qui luật dưới đây:
//		Nếu điểm >= 9.0 - Loại xuất sắc
//		Nếu 8.0<= điểm < 9.0 - Loại giỏi
//		Nếu 7.0<= điểm < 8.0 - Loại khá 
//		Nếu 6.0 <= điểm < 7.0 - Loại trung bình khá
//		Nếu 5.0 <= điểm < 6.0 - Loại trung bình
//		Nếu điểm < 5.0 - Loại kém
//		Với điểm = ( (điểm toán)*2 + điểm lý + điểm hóa )/4
//		Viết Chương trình:
//		a. Nhập vào điểm 3 môn học
//		b. Tính điểm trung bình
//		c. Xác định học lực của học sinh dự

	public static void xepLoai() {
		Scanner scanner4 = new Scanner(System.in);

		System.out.print("Moi ban nhap diem mon Toan: ");
		float t = scanner4.nextFloat();

		System.out.print("Moi ban nhap diem mon Ly: ");
		float l = scanner4.nextFloat();

		System.out.print("Moi ban nhap diem mon Hoa: ");
		float h = scanner4.nextFloat();

		float tb = (t * 2 + l + h) / 4f;
		System.out.print("Diem trung binh la: " + tb +"\n");

		if (tb < 5.0) {
			System.out.println("Loại kém");
		} else if (tb < 6.0) {
			System.out.println("Loại trung bình");
		} else if (tb < 7.0) {
			System.out.println("Loại trung bình khá");
		} else if (tb < 8.0) {
			System.out.println("Loại khá");
		} else if (tb < 9.0) {
			System.out.println("Loại giỏi");
		} else {
			System.out.println("Loại xuất sắc");
		}

		
		
		
		
		
		
	}

}
