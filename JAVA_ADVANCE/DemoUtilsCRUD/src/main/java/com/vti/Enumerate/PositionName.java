package com.vti.Enumerate;

public enum PositionName {
	DEV("Dev"), TEST("Test"), SCRUM_MASTER("ScrumMaster"), PM("PM");

	private String value;

	private PositionName(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static PositionName of(String value) {
		if (value == null) {
			return null;
		}
		
		for (PositionName names : PositionName.values()) {
			if (names.getValue().equalsIgnoreCase(value)) {
				return names;
			}
		}
		return null;
	}

}
