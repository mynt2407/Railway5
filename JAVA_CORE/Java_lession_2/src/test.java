import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test {
public static void main(String[] args) throws ParseException {
	
	Scanner scanner1 = new Scanner(System.in);
	System.out.println("Moi ban nhap vao ngay sinh: ");
	String dateInput = scanner1.next();

	String pattern = "dd/MM/yyyy";
	SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
	Date birthday = dateFormat.parse(dateInput);
	System.out.println("Ngay sinh cua ban la:" + birthday);
		
	
}
}
