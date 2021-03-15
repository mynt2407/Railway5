import java.util.Date;

public class Program {

	public static void main(String[] args) {

		// create department

		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketing";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "Director";

		// create group
		Group group1 = new Group();
		group1.id = 1;
		group1.groupName = "Nhom Java Fresher";

		Group group2 = new Group();
		group2.id = 2;
		group2.groupName = "Nhom C# Fresher";

		Group group3 = new Group();
		group3.id = 3;
		group3.groupName = "Nhom PHP Fresher";

		// Possition

		Position Position1 = new Position();
		Position1.id = 1;
		Position1.positionName = PositionName.DEV;

		Position Position2 = new Position();
		Position2.id = 2;
		Position2.positionName = PositionName.TEST;

		Position Position3 = new Position();
		Position3.id = 3;
		Position3.positionName = PositionName.PM;

		// create account

		Account account1 = new Account();
		account1.id = 1;
		account1.email = "duynguyen1@gmail.com";
		account1.userName = "duy.nguyenngoc";
		account1.fullName = "Nguyen Ngoc Duy";
		account1.department = department1;
		account1.position = Position1;
		account1.createDate = new Date(95, 11, 20);
		account1.gender = Gender.MALE;

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "mynt2407@gmail.com";
		account2.userName = "mynguyen";
		account2.fullName = "Nguyen Thi My";
		account2.department = department1;
		account2.position = Position2;
		account2.createDate = new Date(93, 10, 01);
		account2.gender = Gender.UNKNOW;

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "tongnhung@gmail.com";
		account3.userName = "nhung.tong";
		account3.fullName = "Tong Thi Nhung";
		account3.department = department3;
		account3.position = Position1;
		account3.createDate = new Date(91, 0, 12);
		account3.gender = Gender.FEMALE;

		// xet xem account1 thuoc group nao

		GroupAccount groupaccount1 = new GroupAccount();
		groupaccount1.groups = group2;
		groupaccount1.accounts = account1;
		groupaccount1.joinDate = new Date(90, 11, 20);

		GroupAccount groupaccount2 = new GroupAccount();
		groupaccount2.groups = group1;
		groupaccount2.accounts = account1;
		groupaccount2.joinDate = new Date(89, 01, 22);

		GroupAccount[] groupOfAccount1 = { groupaccount2, groupaccount1 };
		account1.groups = groupOfAccount1;

		// TypeQuestion

		// CategoryQuestion
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.id = 1;
		categoryQuestion1.categoryName = "Loại 1";

		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.id = 2;
		categoryQuestion2.categoryName = "Loại 2";

		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.id = 3;
		categoryQuestion3.categoryName = "Loại 3";

		// Exam
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "Ex_1";
		exam1.title = "Bài kiểm tra C#";
		exam1.duration = Duration.MINUTE_15;
		exam1.creator = account2;

		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "Ex_2";
		exam2.title = "Bài kiểm tra C++";
		exam2.duration = Duration.MINUTE_30;
		exam2.creator = account2;

		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "Ex_3";
		exam3.title = "Bài kiểm tra Java";
		exam3.duration = Duration.MINUTE_40;
		exam3.creator = account3;

		// Question

		Question question1 = new Question();
		question1.id = 1;
		question1.content = "Java là gì";
		question1.category = categoryQuestion1;
		question1.type = TypeQuestionName.ESSAY;
		question1.creator = account3;
		question1.createDate = new Date(89, 02, 01);

		Exam[] GroupOfQuestion1 = { exam1 };
		question1.exams = GroupOfQuestion1;

		Question question2 = new Question();
		question2.id = 2;
		question2.content = "SQL là gì";
		question2.category = categoryQuestion3;
		question2.type = TypeQuestionName.MULTIPLE_CHOICE;
		question2.creator = account1;
		question2.createDate = new Date(120, 11, 03);

		Exam[] GroupOfQuestion2 = { exam3, exam1 };
		question2.exams = GroupOfQuestion2;

		Question question3 = new Question();
		question3.id = 3;
		question3.content = "INT là gì";
		question3.category = categoryQuestion1;
		question3.type = TypeQuestionName.MULTIPLE_CHOICE;
		question3.creator = account1;
		question3.createDate = new Date(100, 02, 01);

		Exam[] GroupOfQuestion3 = { exam2, exam1 };
		question3.exams = GroupOfQuestion3;

		// Answer
		Answer answer1 = new Answer();
		answer1.id = 1;
		answer1.content = "Ngôn ngữ lập trình";
		answer1.question = question2;

		Answer answer2 = new Answer();
		answer2.id = 2;
		answer2.content = "Ngôn ngữ máy tính";
		answer2.question = question1;

		Answer answer3 = new Answer();
		answer3.id = 1;
		answer3.content = "Ngôn ngữ ABC";
		answer3.question = question2;

		System.out.println("Thông tin phòng ban 1:");
		System.out.println("ID:" + department1.id);
		System.out.println("Name:" + department1.name);
		System.out.println("\n");

		System.out.println("Thông tin group 2:");
		System.out.println("ID:" + group2.id);
		System.out.println("Name:" + group2.groupName);
		System.out.println("\n");

		System.out.println("Thông tin account 1:");
		System.out.println("ID:" + account1.id);
		System.out.println("Email:" + account1.email);
		System.out.println("Username:" + account1.userName);
		System.out.println("Full Name:" + account1.fullName);
		System.out.println("Department Name:" + account1.department.name);
		System.out.println("Name:" + account1.email);
		System.out.println("Position:" + account1.position.positionName);
		System.out.println("Create Date:" + account1.createDate);
		System.out.println("Gender:" + account1.gender);

		System.out.println("join Date:" + account1.groups[0].joinDate);
		System.out.println("Tên nhóm:" + account1.groups[0].groups.groupName);
		System.out.println("\n");
		
		for (GroupAccount groupAccount : account1.groups) {
			System.out.println("Ngày tham gia:" + groupAccount.joinDate);
			System.out.println("Tên nhóm:" + groupAccount.groups.groupName);
		}

		System.out.println("\n");

		System.out.println("Loại câu hỏi 1:");
		System.out.println("Category Question ID:" + categoryQuestion1.id);
		System.out.println("Category Question Name:" + categoryQuestion1.categoryName);
		System.out.println("\n");

		System.out.println("ID của bài thi 1 là:");
		System.out.println("Bài thi 1:" + exam1.id);
		System.out.println("Code bài thi:" + exam1.code);
		System.out.println("Chủ đề bài thi:" + exam1.title);
		System.out.println("Thời gian thi:" + exam1.duration);
		System.out.println("Người tạo bài thi:" + exam1.creator.fullName);
		System.out.println("\n");

		System.out.println("ID câu hỏi 1 là:" + question1.id);
		System.out.println("Nôi dung câu hỏi:" + question1.content);
		System.out.println("Category câu hỏi:" + question1.category.categoryName);
		System.out.println("Type câu hỏi:" + question1.type);
		System.out.println("Người tạo câu hỏi:" + question1.creator.fullName);
		System.out.println("Ngày tạo câu hỏi:" + question1.createDate);

		System.out.println("Câu hỏi thuộc bài thi:" + question1.exams[0].title);

		System.out.println("\n");

		System.out.println("ID câu trả lời 1 la:" + answer1.id);
		System.out.println("Nội dung câu trả lời:" + answer1.content);
		System.out.println("Nội dung câu hỏi:" + answer1.question.content);

	}
}
