
public class IN_CLASS {
public static void main(String[] args) {
	// upcasting
	int a =5;
	int b = a;
	System.out.println(b);
	
	// downcasting // ep kieu khong dung se in ra du lieu sai, he thong ko bao loi
	short i = 1000;
	byte j = (byte) i;
	System.out.println(j);
	
	float c = (float) a/b; 
	System.out.println(c);
	
	float d = (float) (a/b);
}
}
