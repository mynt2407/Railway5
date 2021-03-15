package com.vti.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.vti.validation.group.OnCreate;
import com.vti.validation.group.OnUpdate;

public class DepartmentDTO {

	@Null(groups = OnCreate.class)
	@NotNull(groups = OnUpdate.class)
	@NotNull
	@NotBlank
	private int id;

	@NotNull(groups = {OnCreate.class, OnUpdate.class})
	private String name;

	public DepartmentDTO() {
	}

	public DepartmentDTO(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", name=" + name + "]";
	}

}
