package com.vti.Enumerate;

public enum SalaryName {
	DEV("600"), TEST("700"), SCRUM_MASTER("1500"), PM("2000");

	private String value;

	private SalaryName(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static SalaryName of(String value) {
		if (value == null) {
			return null;
		}
		
		for (SalaryName names : SalaryName.values()) {
			if (names.getValue().equalsIgnoreCase(value)) {
				return names;
			}
		}
		return null;
	}

}
