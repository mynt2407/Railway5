
public class Boxing_Unboxing {
	public static void main(String[] args) {
//		question1();
//		question2();
		question3();
	}

//	Question 1:
//		Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//		Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
//		float có 2 số sau dấu thập phân)
	public static void question1() {
		Integer salary1 = new Integer(5000);
		float salary2 = salary1.floatValue();
		System.out.printf("%.2f", salary2);
	}

	public static void question2() {
//	Question 2:
//		Khai báo 1 String có value = "1234567"
//		Hãy convert String đó ra số int

		String value = "1234567";
		int value1 = Integer.parseInt(value);
		System.out.println(value1);

	}
	public static void question3() {
		
	
//	Question 3:
//		Khởi tạo 1 số Integer có value  "1234567"
//		Sau đó convert số trên thành datatype int
		// Cach 1:
		Integer a = 1234567;
		int b = a;
		System.out.println(b);
		
		//cach 2:
		Integer integer1 = new Integer(123456);
		int integer2 = integer1.intValue();
		System.out.println(integer2);
}
}