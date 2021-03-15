package com.vti.frontend;

import java.util.List;

import com.vti.datalayer.AccountRepository;
import com.vti.datalayer.ExamRepository;
import com.vti.entity.Account;
import com.vti.entity.Exam;

public class ExamTest {
	public static void main(String[] args) {

		ExamRepository examRepository = new ExamRepository();

//		System.out.println("***********GET ALL EXAM***********");
//		List<Exam> exams = examRepository.getAllExam();
//		System.out.printf("%-15s %-30s %-25s %-25s \n", "Code1", "Title", "Duration", "CreateDate");
//		for (Exam exam : exams) {
//			System.out.printf("%-15s %-30s %-25s %-25s\n", exam.getCode1(), exam.getTitle(), exam.getDuration(),
//					exam.getCreateDate());
//		}

		System.out.println("\n\n***********CREATE EXAM ***********");

		Exam exam = new Exam();
		exam.setTitle("Bài thi mới");
		exam.setDuration((short) 185);
		examRepository.createExam(exam);

	}
}
