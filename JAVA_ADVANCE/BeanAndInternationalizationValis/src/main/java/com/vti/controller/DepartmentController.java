package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDTO;
import com.vti.validation.group.OnCreate;
import com.vti.validation.group.OnUpdate;

@RestController
@RequestMapping(value = "api/v1/departments")
@Validated

public class DepartmentController {

	@GetMapping
	public ResponseEntity<?> getAllDepartment(@RequestParam @Min(value = 1, message = "{Department.getAllDepartment.pageSize.Min}") int pageSize) {

		// get data
		List<String> entities = new ArrayList<>();

		entities.add("Sale");
		entities.add("Marketing");
		entities.add("BOD");
		return new ResponseEntity<List<String>>(entities, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable(name = "id") @Min(1) short id) {
		return new ResponseEntity<String>("Sale", HttpStatus.OK);
	}

	@Validated(OnCreate.class)
	@PostMapping
	public ResponseEntity<?> createDepartment(@Valid @RequestBody DepartmentDTO dto) {

		System.out.println(dto);

		return new ResponseEntity<String>( "Create successfully!", HttpStatus.OK);
	}

	@Validated(OnUpdate.class)
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@Valid @PathVariable(name = "id") short id, @RequestBody DepartmentDTO dto) {

		System.out.println(dto);

		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

}
