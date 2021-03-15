 package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.Utils.Paging;
import com.vti.Utils.Sorting;
import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@GetMapping
	public ResponseEntity<?> getAllDepartment(Paging paging, Sorting sort, FilterDepartment filter, String search) {
		//set default 
		if (paging == null) {
			paging = new Paging(10, 1);
		}
		if (sort == null || sort.getSortField() == null || sort.getSortType() == null) {
			sort = new Sorting("name", "ASC");
		}
		
		
		// get data
		List<Department> entities = service.getAllDepartment(paging, sort, filter, search);

//		List<String> dtos = new ArrayList<>();
//
//		// convert entity to dto
//		for (Department entity : entities) {
//			dtos.add(entity.getName());
//		}
		return new ResponseEntity<List<Department>>(entities, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable(name = "id") short id) {
		return new ResponseEntity<Department>(service.getDepartmentById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/{name}")
	public ResponseEntity<?> getDepartmentByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<Department>(service.getDepartmentByName(name), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentDTO departmentdto) {
		service.createDepartment(departmentdto.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
			@RequestBody DepartmentDTO departmentdto) {
		Department department2 = departmentdto.toEntity();
		department2.setId(id);
		service.updateDepartment(department2);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
