package com.vti.primarykey;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
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

@Embeddable
public class GroupAccountKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID", nullable = false)
	private short groupId;

	@Column(name = "AccountID", nullable = false)
	private short accountId;
	
	public GroupAccountKey() {

	}

	public short getGroupId() {
		return groupId;
	}

	public void setGroupId(short groupId) {
		this.groupId = groupId;
	}

	public short getAccountId() {
		return accountId;
	}

	public void setAccountId(short accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "GroupAccountKey [groupId=" + groupId + ", accountId=" + accountId + "]";
	}

	

	

}
