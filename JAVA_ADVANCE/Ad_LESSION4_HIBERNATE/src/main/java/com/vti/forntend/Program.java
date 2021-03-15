package com.vti.forntend;

import java.util.List;

import com.vti.datalayer.GroupRepository;
import com.vti.entity.Group;

public class Program {
	public static void main(String[] args) {

		GroupRepository groupRepository = new GroupRepository();

		System.out.println("***********GET ALL DEPARTMENTS***********");
		List<Group> groups = groupRepository.getAllGroup();
		for (Group group : groups) {
			System.out.println(group);
		}
		
		System.out.println("\n\n***********GET DEPARTMENT BY ID***********");
		Group groupById = groupRepository.getGroupById((short) 2);
		System.out.println(groupById);
		
		System.out.println("\n\n***********GET DEPARTMENT BY NAME***********");
		Group groupByName = groupRepository.getGroupByName("VTI Sale 01");
		System.out.println(groupByName);
		
		System.out.println("\n\n***********CREATE DEPARTMENT ***********");
		Group group = new Group();
		group.setName("ABC");
		groupRepository.createGroup(group);

		System.out.println("\n\n***********UPDATE DEPARTMENT ***********");
		// Cach 1:
		groupRepository.updateGroup((short) 2, "Nhom moi");
		
		//cách 2: 
		Group group1 = new Group();
		group1.setId((short) 5);
		group1.setName("Nhom dep trai");
		groupRepository.updateGroup(group1);
		
		System.out.println("\n\n***********DELETE DEPARTMENT ***********");
		groupRepository.deleteGroup((short) 4);
		
		System.out.println("\n\n***********CHECK ID EXIST ***********");
		System.out.println(groupRepository.isGroupExistById((short) 5));
		
		System.out.println("\n\n***********CHECK NAME EXIST ***********");
		System.out.println(groupRepository.isGroupExistByName("xyz"));
		
	}
}
