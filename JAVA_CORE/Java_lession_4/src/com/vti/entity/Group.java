package com.vti.entity;

import java.util.Date;

public class Group {
	private short id;
	private String groupName;
	private Date createDate;
	private String creator;
	private Account[] accounts;

	public Group() {

	}

	public Group(String groupName, Date createDate, String creator, Account[] accounts) {
		this.groupName = groupName;
		this.createDate = new Date();
		this.creator = creator;
		this.accounts = accounts;
	}

	public Group(String groupName, Date createDate, String creator, String[] userNames) {
		this.groupName = groupName;
		this.createDate = new Date();
		this.creator = creator;
		Account[] temps = new Account[userNames.length];
		for (int i = 0; i < userNames.length; i++) {
			temps[i] = new Account(userNames[i]);
		}
		this.accounts = temps;

	}

	// getter
	public Date getCreateDate() {
		return createDate;
	}

	public String getCreator() {
		return creator;
	}

	public String getGroupName() {
		return groupName;
	}

	public short getId() {
		return id;
	}

	public Account[] getAccounts() {
		return accounts;
	}

// setter
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = new Date(90, 1, 1);
	}

	public void setCreator(String creator) {
		this.creator = "Hung";
	}

	public void setId(short id) {
		this.id = 2;
	}

	public void setGroupName(String groupName) {
		this.groupName = "Nhom C# fresher";
	}
}