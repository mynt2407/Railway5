package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "Address", catalog = "TestingSystem")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AddressID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "AddressName", nullable = false, length = 100, unique = true)
	private String addressName;

	@OneToOne(mappedBy = "address")
	private DetailDepartment detailDepartment;

	public Address() {

	}

	public Address(String addressName) {
		this.addressName = addressName;
	}

	public Address(short id, String addressName) {
		super();
		this.id = id;
		this.addressName = addressName;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public DetailDepartment getDetailDepartment() {
		return detailDepartment;
	}

	public void setDetailDepartment(DetailDepartment detailDepartment) {
		this.detailDepartment = detailDepartment;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressName=" + addressName + ", detailDepartment=" + detailDepartment + "]";
	}

}
