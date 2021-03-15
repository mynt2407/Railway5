package com.vti.controller;

import java.util.List;
import java.util.function.Function;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.CreateGroupDto;
import com.vti.dto.UpdateGroupDto;
import com.vti.dto.ViewGroupDto;
import com.vti.entity.Group;
import com.vti.service.IGroupService;

@RestController
@RequestMapping(value = "api/v1/groups")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@Validated

public class GroupController {

	@Autowired
	private IGroupService service;

	@GetMapping()

	public ResponseEntity<?> getAllGroups(@RequestParam(defaultValue = "1") int pageNumber,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "DESC") String sortType,
			@RequestParam(defaultValue = "id") String sortField) {

		// convert Page<Group> --> Page<ViewGroupDto>

		Page<Group> entities = service.getAllGroups(pageNumber, pageSize, sortType, sortField);
		Page<ViewGroupDto> dtoPage = entities.map(new Function<Group, ViewGroupDto>() {
			@Override
			public ViewGroupDto apply(Group entity) {
				return entity.toDto();
			}
		});

		return new ResponseEntity<Page<ViewGroupDto>>(dtoPage, HttpStatus.OK);
	}

//get group by id
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getGroupByID(@PathVariable(name = "id") short id) {

		if (service.isGroupExistsByID(id) == false) {
			throw new EntityNotFoundException("Id bạn vừa nhập vào ko có");
		}
		
		return new ResponseEntity<Group>(service.getGroupByID(id), HttpStatus.OK);
	}

//create group
	@PostMapping()
	public ResponseEntity<?> createGroup(@Valid @RequestBody CreateGroupDto dto) {
		service.createGroup(dto.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

//edit group
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateGroup(@PathVariable(name = "id") short id, @Valid @RequestBody UpdateGroupDto dto) {

		Group group = service.getGroupByID(id);
		group.setName(dto.getName());
		service.updateGroup(group);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

// delete
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteGroup(@PathVariable(name = "id") short id) {
		service.deleteGroup(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

	// delete array id
	@DeleteMapping()
	public ResponseEntity<?> deleteGroupByIds(@RequestParam List<Short> ids) {
		service.deleteGroupByIds(ids);
		return new ResponseEntity<String>("Delete many groups successfully!", HttpStatus.OK);
	}

}
