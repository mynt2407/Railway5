package com.vti.frontend;

import java.util.List;

import com.vti.datalayer.GroupRepository;
import com.vti.entity.Group;

public class GroupTest {
	public static void main(String[] args) {

		GroupRepository groupRepository = new GroupRepository();

		System.out.println("***********GET ALL GROUP***********");
		List<Group> groups = groupRepository.getAllGroup();
		for (Group group : groups) {
			System.out.println(group);
		}

//		System.out.println("\n\n***********CREATE Account ***********");
//		Account Account = new Account();
//		Account.setEmail("mynt2407@gmail.com");
//		Account.setUserName("NeoNguyen123");
//		Account.setFirstName("Neo");
//		Account.setLastName("Nguyen");
//		Account.setDepartment(new Department());
//		AccountRepository.createAccount(Account);

	}
}
