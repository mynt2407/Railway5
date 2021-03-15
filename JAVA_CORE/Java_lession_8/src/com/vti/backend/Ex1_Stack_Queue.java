package com.vti.backend;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.vti.entity.Student;

public class Ex1_Stack_Queue {
//	Question 2 (Optional): Stack & Queue
//	Khai báo 1 danh sách lưu các tên học sinh tới tham dự phỏng vấn, thứ
//	tự tới của các học sinh như sau:
//	Nguyễn Văn Nam, Nguyễn Văn Huyên, Trần Văn Nam,
//	Nguyễn Văn A
//	a) Tạo 1 method để in ra thứ tự tới của các học sinh theo thứ tự
//	sớm nhất tới muộn nhất (gợi ý dùng Stack)
//	b) Tạo 1 method để in ra thứ tự tới của các học sinh theo thứ tự từ
//	muộn nhất tới sớm nhất (gợi ý dùng Queue)

	public static void useStack() {
		// Cau a
		Stack<Student> stacks = new Stack<Student>();
		stacks.push(new Student("Nguyễn Văn Nam"));
		stacks.push(new Student("Nguyễn Văn Huyên"));
		stacks.push(new Student("Trần Văn Nam"));
		stacks.push(new Student("Nguyễn Văn A"));

		System.out.println(stacks.peek());
		System.out.println(stacks);

	}

	public static void useQueue() {
		Queue<Student> queue = new LinkedList<Student>();
		queue.add(new Student("my1"));
		queue.add(new Student("my2"));
		queue.add(new Student("my3"));
		
		System.out.println(queue.peek());
		System.out.println(queue);
	}
}