package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

//@Accessors de khong phai viet "getId" thay vao do chi can viet "id"

@Accessors(fluent = true) @Getter
@Setter

//constructor ko tham so
@NoArgsConstructor

//constructor nhieu tham so
@AllArgsConstructor

//it dung
@EqualsAndHashCode

//@ToString(exclude = "id")
//se tu dong in ra object do ma khong can ham toString. Neu them (exclude = "id") se khong in ra truong id

//@ToString(callSuper = true)
// tu dong goi den thang cha (super().toString)

@ToString

@Data
//bao gom: @Getter, @Setter, @NoArgsConstructor, @ToString

public class Department {
	private int id;
	private String name;
}
