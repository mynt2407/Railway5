package com.vti.Utils;

public class Sorting {
	private String sortField;
	private String sortType;

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public Sorting(String sortField, String sortType) {
		this.sortField = sortField;
		this.sortType = sortType;
	}

}
