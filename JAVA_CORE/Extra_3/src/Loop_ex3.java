import java.util.Scanner;

public class Loop_ex3 {
	public static void main(String[] args) {
//		question1();
//		question2();
		question3();
//		question4();

	}

//	Question 1:
	//	Nháº­p vÃ o dÃ£y n sá»‘ thá»±c. TÃ­nh tá»•ng dÃ£y, trung bÃ¬nh dÃ£y, tá»•ng cÃ¡c sá»‘ Ã¢m,
	//	dÆ°Æ¡ng vÃ  tá»•ng cÃ¡c sá»‘ á»Ÿ vá»‹ trÃ­ cháºµn, vá»‹ trÃ­ láº» trong dÃ£y

	public static void question1() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ban muon nhap vao bao nhieu so thuc? ");
		int input_n = scanner.nextInt();

		float[] input = new float[input_n];
		float t = 0;
		float tb = 0;
		float tb2 = 0;
		float tb3 = 0;
		float tc = 0;
		float tl = 0;

		for (int i = 0; i < input.length; i++) {
			System.out.println("moi ban nhap so thuc thu " + (i + 1) + " : ");
			float input_so = scanner.nextFloat();

			t += input_so;
			tb = t / input_n;
			if (input_so < 0) {
				tb2 += input_so;
			}
			if (input_so > 0) {
				tb3 += input_so;
			}
			if (i % 2 != 0) {
				tc += input_so;
			}
			if (i % 2 == 0) {
				tl += input_so;
			}
		}
		System.out.println("Tong la: " + t);
		System.out.println("Trung binh day la: " + tb);
		System.out.println("Tong cac so am la: " + tb2);
		System.out.println("Tong cac so duong la: " + tb3);
		System.out.println("Tong cac so o vi tri chan la: " + tc);
		System.out.println("Tong cac so o vi tri le la: " + tl);

	}

	//Question 2: TÃ¬m vÃ  chá»‰ ra vá»‹ trÃ­ xuáº¥t hiá»‡n Ä‘áº§u tiÃªn cá»§a pháº§n tá»­ x trong dÃ£y
	public static void question2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ban muon nhap vao bao nhieu so? ");
		int input_number = scanner.nextInt();

		int[] arrays_number = new int[input_number];
		
		for (int i = 0; i < arrays_number.length; i++) {
			System.out.print("So thu " + (i + 1) + " la: ");
			arrays_number[i] = scanner.nextInt();
		}

		System.out.print("Moi ban nhap vao phan tu x: ");
		int number1 = scanner.nextInt();

		for (int j = 0; j < arrays_number.length; j++) {

			if (arrays_number[j] == number1) {
				System.out.println("So x ban vua nhap vao o vi tri thu: " + (j + 1));
				break;
			}

		}
	}

	//Question 3: HÃ£y nháº­p vÃ o 16 sá»‘ nguyÃªn. In ra thÃ nh 2 dÃ²ng, 8 cá»™t.
	public static void question3() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap vao 16 so nguyen! ");

		int[] inputs = new int[16];
		for (int i = 0; i < 16; i++) {
			System.out.print("So thu " + (i + 1) + " la: ");
			inputs[i] = scanner.nextInt();
		}
		// In theo hang

		for (int i = 0; i < 2; i++) {
			System.out.print("Hang thu " + (i + 1) + " la: ");
			
			for (int j = 0; j < 8; j++) {
				System.out.print((inputs[j + i * 8] + " "));
			}
			System.out.print("\n");
		}
	}

	//Question 4: Nháº­p vÃ o dÃ£y sá»‘. In ra dÃ£y Ä‘Ã£ Ä‘Æ°á»£c sáº¯p xáº¿p tÄƒng dáº§n, giáº£m dáº§n
	public static void question4() {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ban muon nhap bao nhieu so? ");
		int input_so = scanner.nextInt();

		int[] numbers = new int[input_so];
		int min = numbers[0];
		int count = 0;

		for (int j = 0; j < numbers.length; j++) {
			System.out.println("So thu " + (j + 1) + " la: ");
			numbers[j] = scanner.nextInt();

			for (int i = 0; i < numbers.length - 1; i++) {
				if (numbers[j] < min) {
					min = numbers[j];
				}
			}

		}
		System.out.println(min);
	}
//	Question 5:
//		Cho má»™t dÃ£y cÃ¡c sá»‘ sau: 10, 20, 90, 50, 100, 60, 30, 80, 70, 40.
//		HÃ£y sáº¯p xáº¿p cÃ¡c dÃ£y nÃ y theo chiá»�u tÄƒng dáº§n, giáº£m dáº§n
//		YÃªu cáº§u:
//		Thiáº¿t káº¿ giao diá»‡n console nháº­p tá»«ng pháº§n tá»­ vÃ  hiá»ƒn thá»‹ káº¿t
//		quáº£ ra mÃ n hÃ¬nh.
//		Sau khi nháº­p Ä‘á»§ 10 pháº§n tá»­ theo Ä‘Ãºng thá»© tá»± nhÆ° Ä‘á»� bÃ i thÃ¬
//		thá»±c hiá»‡n sáº¯p xáº¿p theo chiá»�u tÄƒng dáº§n, giáº£m dáº§n

}
