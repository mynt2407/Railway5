package com.vti.dto;

import java.util.Date;

public class ViewGroupDto {

	private short id;
	private String name;
	private short member;
	private String fullname;
	private Date createDate;

	public ViewGroupDto() {
	}

	public ViewGroupDto(short id, String name, short member, String fullname, Date createDate) {
		this.id = id;
		this.name = name;
		this.member = member;
		this.fullname = fullname;
		this.createDate = createDate;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getMember() {
		return member;
	}

	public void setMember(short member) {
		this.member = member;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


}
