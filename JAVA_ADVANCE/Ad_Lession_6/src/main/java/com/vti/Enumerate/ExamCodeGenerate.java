package com.vti.Enumerate;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.vti.datalayer.ExamRepository;
import com.vti.entity.Exam;

public class ExamCodeGenerate implements IdentifierGenerator {

	ExamRepository examRepository;

	public ExamCodeGenerate() {
		examRepository = new ExamRepository();
	}

	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Exam exam = (Exam) object;

		String prefix;

		if (exam.getDuration() >= 180) {
			prefix = "L";
		} else if (exam.getDuration() >= 90) {
			prefix = "M";
		} else {
			prefix = "S";
		}
		int count = examRepository.getCountOfExamCode(exam.getDuration());
		return prefix + "-" + (count+1);
	}

}
