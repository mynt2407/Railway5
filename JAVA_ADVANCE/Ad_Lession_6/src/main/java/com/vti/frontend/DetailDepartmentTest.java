package com.vti.frontend;

import java.util.List;

import com.vti.datalayer.AccountRepository;
import com.vti.datalayer.AddressRepository;
import com.vti.datalayer.DetailDepartmentRepository;
import com.vti.entity.Account;
import com.vti.entity.Address;
import com.vti.entity.DetailDepartment;

public class DetailDepartmentTest {
	public static void main(String[] args) {

		DetailDepartmentRepository repository = new DetailDepartmentRepository();
		AddressRepository addressRepository = new AddressRepository();

		System.out.println("***********GET ALL DETAIL DEPARTMENT***********");
		List<DetailDepartment> detailDepartments = repository.getDetailDepartment();
		
		for (DetailDepartment department : detailDepartments) {
			System.out.println(department);
		}

		System.out.println("\n\n***********CREATE DETAIL DEPARTMENT ***********");
		
		DetailDepartment detailDepartment = new DetailDepartment();
		detailDepartment.setEmulationPoint((short) 3);
		detailDepartment.setName("Nhom moi");
		//detailDepartment.setAddress(new Address("P100")); Nếu không có id thì Save trong AddressRepository nghĩa là tạo mới
		detailDepartment.setAddress(new Address((short) 1, "101")); // Nếu có id thì Save trong AddressRepository nghĩa là update
	
		repository.createDetailDepartment(detailDepartment);

	}
}
