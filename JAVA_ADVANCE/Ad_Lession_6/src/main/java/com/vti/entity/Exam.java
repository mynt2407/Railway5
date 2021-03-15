package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Exam", catalog = "TestingSystem")
public class Exam implements Serializable {

	private static final long serialVersionUID = 1L;

//	@Column(name = "ExamID")
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private short id;

	@Column(name = "`Code1`", length = 10)
	@Id
	@GeneratedValue(generator = "exam-code-generator")
	@GenericGenerator(name ="exam-code-generator", strategy = "com.vti.Enumerate.ExamCodeGenerate")
	private String code1;

	@Column(name = "Title", nullable = false, length = 50)
	private String title;

	@Column(name = "Duration", nullable = false, columnDefinition = "tinyint default 45")
	private short duration;

	@Column(name = "CreateDate", updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

//	@PrePersist
//	public void beforeSaveToDatabase() {
//		if (code1 == null) {
//			ExamRepository examRepository = new ExamRepository();
//			String prefix;
//			if (duration >= 180) {
//				prefix = "L";
//			} else if (duration >= 90) {
//				prefix = "M";
//			} else {
//				prefix = "S";
//			}
//			//int count = examRepository.
//		}
//	}

	public Exam() {

	}

//	public short getId() {
//		return id;
//	}
//
//	public void setId(short id) {
//		this.id = id;
//	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Exam [ code1=" + code1 + ", title=" + title + ", duration=" + duration + ", createDate="
				+ createDate + "]";
	}

}
