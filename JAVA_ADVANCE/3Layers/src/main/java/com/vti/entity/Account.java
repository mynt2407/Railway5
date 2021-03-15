package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;


@Entity
@Table(name = "`Account`", catalog = "TestingSystem")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "Email", nullable = false, length = 50, unique = true, updatable = true)
	private String email;

	@Column(name = "Username", nullable = false, length = 50, unique = true, updatable = true)
	private String userName;

	@Column(name = "FirstName", nullable = false, length = 50)
	private String firstName;

	@Column(name = "LastName", nullable = false, length = 50)
	private String lastName;

	@Formula("concat(FirstName,' ',LastName)")
	private String fullName;

	@Column(name = "CreateDate", updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DepartmentID", nullable = false, referencedColumnName = "DepartmentID")
	private Department department;

//	@ManyToOne
//	@JoinColumn(name = "PositionID", nullable = false, referencedColumnName = "PositionID")
//	private Position position;

//	@ManyToOne
//	@JoinColumn(name = "SalaryID", nullable = false, referencedColumnName = "SalaryID")
//	private Salary salary;
//
//	@OneToOne(mappedBy = "creator")
//	private Group group;
//
//	@OneToMany(mappedBy = "account")
//	List<GroupAccount> groups;

	public Account() {

	}

	public Account(short id, String email, String userName) {
		this.id = id;
		this.email = email;
		this.userName = userName;	
	}
	public Account(String email, String userName, String firstName, String lastName) {
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

//	public Position getPosition() {
//		return position;
//	}
//
//	public void setPosition(Position position) {
//		this.position = position;
//	}
//
//	public Salary getSalary() {
//		return salary;
//	}
//
//	public void setSalary(Salary salary) {
//		this.salary = salary;
//	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", fullName=" + fullName + ", createDate=" + createDate + "]";
	}

//	department="
//			+ department + ",

}
