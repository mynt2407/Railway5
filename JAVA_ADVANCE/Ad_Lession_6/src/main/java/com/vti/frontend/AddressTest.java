package com.vti.frontend;

import java.util.List;

import com.vti.datalayer.AccountRepository;
import com.vti.datalayer.AddressRepository;
import com.vti.entity.Account;
import com.vti.entity.Address;

public class AddressTest {
	public static void main(String[] args) {

		AddressRepository repository = new AddressRepository();

		System.out.println("***********GET ALL Address***********");
		List<Address> addresses = repository.getAllAddress();
		for (Address address : addresses) {
		System.out.println(address);
		}

//		System.out.println("\n\n***********CREATE Address ***********");
//		Account Account = new Account();
//		Account.setEmail("mynt2407@gmail.com");
//		Account.setUserName("NeoNguyen123");
//		Account.setFirstName("Neo");
//		Account.setLastName("Nguyen");
//	//	Account.setDepartment(new Department());
//		AccountRepository.createAccount(Account);

	}
}
