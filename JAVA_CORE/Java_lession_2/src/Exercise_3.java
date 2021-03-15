import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Exercise_3 {
	public static void main(String[] args) {

		// Exam
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "Ex_1";
		exam1.title = "Bài kiểm tra C#";
		exam1.duration = Duration.MINUTE_15;
		exam1.createDate = new Date(110, 01, 10);

		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "Ex_2";
		exam2.title = "Bài kiểm tra C++";
		exam2.duration = Duration.MINUTE_30;
		exam2.createDate = new Date(119, 00, 11);

		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "Ex_3";
		exam3.title = "Bài kiểm tra Java";
		exam3.duration = Duration.MINUTE_40;
		exam3.createDate = new Date(120, 11, 24);

//	Exercise 3 (Optional): Date Format

//	Question 1:
//	In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
//	dạng vietnamese

		System.out.println("Id cua exam thu 1 la: " + exam1.id);
		System.out.println("Code cua exam thu 1 la: " + exam1.code);
		System.out.println("Title cua exam thu 1 la: " + exam1.title);
		System.out.println("Duration cua exam thu 1 la: " + exam1.duration);
		System.out.println("CreateDate cua exam thu 1 la: " + exam1.createDate);

		Locale locale = new Locale("vi", "VN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(exam1.createDate);
		System.out.println(date);
		System.out.println("\n");

//		Question 2:
//			In ra thông tin: Exam đã tạo ngày nào theo định dạng
//			Năm – tháng – ngày – giờ – phút – giây

		String pattern1 = "yyyy - MM - dd HH : mm : ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern1);
		Exam[] exams = { exam1, exam2, exam3 };
		for (Exam exam : exams) {
			String date1 = simpleDateFormat.format(exam.createDate);
			System.out.println(date1);
			System.out.println("\n");
		}

//		Question 3:
//			Chỉ in ra năm của create date property trong Question 2
//		
		String pattern2 = "yyyy";
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
		for (Exam exam_2 : exams) {
			String date2 = simpleDateFormat2.format(exam_2.createDate);
			System.out.println(date2);
		}
		System.out.println("\n");
		
//		Question 4:
//			Chỉ in ra tháng và năm của create date property trong Question 2	
		
		String pattern3 = "MM - yyyy";
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(pattern3);
		for (Exam exam_3 : exams) {
			String date3 = simpleDateFormat3.format(exam_3.createDate);
			System.out.println(date3);
		}
		System.out.println("\n");
		
//		Question 5:
//			Chỉ in ra "MM-DD" của create date trong Question 2
		String pattern4 = "MM-DD";
		SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat(pattern4);
		for (Exam exam_4 : exams) {
			String date4 = simpleDateFormat4.format(exam_4.createDate);
			System.out.println(date4);
		}
		
		
		
		
		
		
		
		
		
	}	
}
