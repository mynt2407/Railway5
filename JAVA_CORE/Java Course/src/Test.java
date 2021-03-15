import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 
 */

/**
 * @author MyNguyen
 *
 */
public class Test {
	public static void main(String[] args) {

		// bai 1:

		// n = 3
		int input[] = { 11, 2, 8, 10, 5, 99, 1, 8, 9 };

		int n = input.length;

		for (int y = 0; y < 3; y++) {
			int i1 = 0;
			int i2 = n / 3;
			int i3 = 2 * n / 3;

			System.out.println(input[y + i1]);
			System.out.println(input[y + i2]);
			System.out.println(input[y + i3]);
		}
		System.out.println("---------------------");
		// bai 3:

		Integer[] numbers = { 1, 5, 4, 7, 9, 0, -10, 13, 93, 14, 15 };

//		Arrays.sort(numbers, Collections.reverseOrder());
//		String newArrays = Arrays.toString(numbers);
//
//		Integer a = numbers[numbers.length - 1];
//		Integer b = numbers[numbers.length - 2];
//		System.out.println("Tong la: " + (a + b));
//
//		System.out.printf("Modified numbers : %s", Arrays.toString(numbers));
//		System.out.println("--------------\n");
//		for (int i = 0; i < numbers.length - 1; i++) {
//			for (int j = i + 1; j < numbers.length; j++) {
//				System.out.println(numbers[i] - numbers[j]);
//				Integer Arr = numbers[i] - numbers[j];
//			}
//			
//		}
		

	}
}
