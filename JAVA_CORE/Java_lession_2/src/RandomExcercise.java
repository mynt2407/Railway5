import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomExcercise {
	public static void main(String[] args) {
		// randomNumber();
		// randomName();
		// randomDate();
		// bubbleSort();
		// SortArray();
		//FindCoupleNumber();
		<%int i = 1;
		i; %>
	}

	public static void randomNumber() {
//		Question 1:
//		In ngáº«u nhiÃªn ra 1 sá»‘ nguyÃªn

		Random random = new Random();
		int x = random.nextInt();
		System.out.println(x);
		System.out.println("\n");

//		Question 2:
//		In ngáº«u nhiÃªn ra 1 sá»‘ thá»±c 
		float y = random.nextFloat();
		System.out.println(y);
		System.out.println("\n");

		// Question 7: Láº¥y ngáº«u nhiÃªn 1 sá»‘ cÃ³ 3 chá»¯ sá»‘
// Cach 1:
		int z = ThreadLocalRandom.current().nextInt(100, 1000);
		System.out.println(z);
		System.out.println("\n");
// cah 2:
		int a = random.nextInt(999 - 100 + 1) + 100;
		System.out.println(a);
		System.out.println("\n");
	}

	public static void randomName() {
//		Question 3:
//		Khai bÃ¡o 1 array bao gá»“m cÃ¡c tÃªn cá»§a cÃ¡c báº¡n trong lá»›p, sau Ä‘Ã³ in ngáº«u nhiÃªn
//		ra tÃªn cá»§a 1 báº¡n
		Random random = new Random();
		String[] students = { "Hoa", "Mai", "Lan", "Ngoc", "Lien", "Minh" };
		int i = random.nextInt(students.length);
		System.out.println(students[i]);
		System.out.println("\n");
	}

	public static void randomDate() {
//		Question 4:
//		Láº¥y ngáº«u nhiÃªn 1 ngÃ y trong khoáº£ng thá»�i gian 24-07-1995 tá»›i ngÃ y 20-12-1995
		Random random = new Random();

		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();

		long randomInt = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);
		System.out.println("\n");

//	Question 5:
//	Láº¥y ngáº«u nhiÃªn 1 ngÃ y trong khoáº£ng thá»�i gian 1 nÄƒm trá»Ÿ láº¡i Ä‘Ã¢y

		int minDay1 = (int) LocalDate.of(2019, 9, 24).toEpochDay();
		int maxDay1 = (int) LocalDate.of(2020, 9, 24).toEpochDay();

		long randomInt1 = minDay1 + random.nextInt(maxDay1 - minDay1);

		LocalDate randomDay1 = LocalDate.ofEpochDay(randomInt1);
		System.out.println(randomDay1);
		System.out.println("\n");

//		Question 6:
//		Láº¥y ngáº«u nhiÃªn 1 ngÃ y trong quÃ¡ khá»©

		int now = (int) LocalDate.now().toEpochDay();
		randomInt = now - random.nextInt(365);
		randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);

	}

	public static void bubbleSort() {
		int[] numbers = { 5, 4, -2, 1, 10, -3, 0 };
		int temp = 0;

		for (int i = 0; i < numbers.length; i++) {

			for (int j = 0; j < numbers.length - 1; j++) {

				if (numbers[j] < numbers[j + 1]) {
					// gán temp bằng number [j] và bê ra chỗ khác
					temp = numbers[j];
					// đổi vị trí của number[j + 1] vào vị trí j cũ
					numbers[j] = numbers[j + 1];
					// gán [j+ 1] bằng thằng temp
					numbers[j + 1] = temp;
				}
			}
		}

		int sum = numbers[0] + numbers[1];
		System.out.println("Tong la: " + sum);

		System.out.println(Arrays.toString(numbers) + " bubbleSort");

	}

	public static void SortArray() {
		int[] numbers = { 11, 2, 8, 10, 5, 99, 1, 8, 9 };

		int x = numbers.length / 3;

		for (int i = 0; i < x; i++) {

			for (int j = 0; j < x; j++) {

				System.out.println(numbers[3 * j + i]);
			}
		}
	}

	public static void FindCoupleNumber() {
		int temp = 0;
		int[] numbers = { 1, 5, 4, 7, 9, 0, -10, 13, 93, 14, 15 };

		for (int i = 0; i < numbers.length; i++) {

			for (int j = 0; j < numbers.length - 1; j++) {

				if (numbers[j] > numbers[j + 1]) {
					// gán temp bằng number [j] và bê ra chỗ khác
					temp = numbers[j];
					// đổi vị trí của number[j + 1] vào vị trí j cũ
					numbers[j] = numbers[j + 1];
					// gán [j+ 1] bằng thằng temp
					numbers[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(numbers) + " bubbleSort");

		int delete[] = {};
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length-1; j++) {	
				// delete[] = numbers[j] - numbers[i];
				
			}
		}
		System.out.println(delete);
	}
}
