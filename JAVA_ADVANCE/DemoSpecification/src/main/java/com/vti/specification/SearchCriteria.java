package com.vti.specification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class SearchCriteria {
	// key - the filed name
	// operation - lessThan, greaterThan, search
	// value- dataType: enum, string, int, date,...

	private String key;
	private String operation;
	private Object value;
}
