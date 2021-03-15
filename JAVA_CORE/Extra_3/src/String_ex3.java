import java.util.Scanner;

public class String_ex3 {
	public static void main(String[] args) {
//		question1();
		question2();
	}

//	Question 1: Nhập xâu họ tên, in ra họ, tên dưới dạng viết hoa
	public static void question1() {

		String fullName = "";
		String name = "";

		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi ban nhap vao ho ten day du: ");
		fullName = scanner.nextLine();

		fullName = fullName.trim();
		fullName = fullName.replaceAll("\\s+", " ");
		String[] fullname_split = fullName.split(" ");

		for (String string : fullname_split) {
			String firstCharater = string.substring(0, 1).toUpperCase();
			String lastCharater = string.substring(1).toLowerCase();
			name = firstCharater + lastCharater;
			fullName += name + " ";
		}
		System.out.println("Ten dung la: " + fullName);

	}

//	Question2: Nhập xâu. In ra tất các các vị trí của chữ ‘a’ trong xâu và tổng số lần xuất hiện của nó.
	public static void question2() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi ban nhap vao xau ki tu: ");
		// String inputS = scanner.nextLine();
		String inputS = "nguyen    van toan   anh";
		inputS = inputS.trim();
		inputS = inputS.replaceAll("\\s+", " ");

		System.out.println(inputS);

		Integer[] x = new Integer[10];
		int indexX = 0;
		for (int i = 0; i < inputS.length(); i++) {
			if (inputS.charAt(i) == 'a') {

				x[indexX] = i + 1;
				indexX++;
			}

		}

		System.out.println("Tong so lan xuat hien cua ki tu a la: " + (indexX + 1));

		for (int j = 0; j < x.length; j++) {
			if (x[j] == null) {
				continue;
			} else {
				System.out.println("Ki tu a o vi tri thu " + x[j]);
			}

		}

	}
}
