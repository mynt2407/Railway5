
public class Constructor_exercise {
	public static void main(String[] args) {

//	Question 1:
//		Tạo constructor cho department:
//		a) không có parameters
//		b) Có 1 parameter là nameDepartment và default id của
//		Department = 0
//		Khởi tạo 1 Object với mỗi constructor ở trên

		Department department = new Department();

		Department department1 = new Department("Nguyen thi my");
		System.out.println(department1.name);
		System.out.println(department1.id);
		
//	Question 2:
//		Tạo constructor cho Account:
//		a) Không có parameters
//		b) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName)
//		c) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName) và
//		Position của User, default createDate = now
//		d) Có các parameter là id, Email, Username, FirstName,
//		LastName (với FullName = FirstName + LastName) và
//		Position của User, createDate
//		Khởi tạo 1 Object với mỗi constructor ở trên
		
		Account account = new Account();
		
//	Account account1 = new Account(1, "duynguyen1@gmail.com", "duy.nguyenngoc", "Nguyen Ngoc Duy", "Duy", "Nguyen Ngoc");
//	System.out.println(account1.firstName);
	}

	
}