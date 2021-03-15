import java.util.Date;

public class Account {
	byte id;
	String email;
	String userName;
	String fullName;
	String firstName;
	String lastName;
	Department department;
	Date createDate;

	Account() {
	}

	Account (byte id, String email, String userName, String fullName, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName ;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}