/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/

DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

/*============================== CREATE TABLE =======================================*/
/*======================================================================================*/

-- create table 1: Department
CREATE TABLE Department(
	DepartmentID 	TINYINT UNSIGNED PRIMARY KEY,
	DepartmentName 	VARCHAR(50) UNIQUE KEY NOT NULL
);

-- create table 2: Position
CREATE TABLE Position (
	PositionID 		TINYINT UNSIGNED PRIMARY KEY,
	PositionName 	ENUM('Sale', 'Digital marketing', 'Test', 'Vice Director', 'Guard', 'Accountant') UNIQUE KEY NOT NULL
);


	-- create table 3: Account
    CREATE TABLE `Account` (
	AccountID 		SMALLINT UNSIGNED PRIMARY KEY,
	Email 			VARCHAR(50) UNIQUE KEY NOT NULL,
	User_name		VARCHAR(50) UNIQUE KEY NOT NULL,
	Full_name 		VARCHAR(50) NOT NULL,
	DepartmentID	TINYINT UNSIGNED,
	PositionID		TINYINT UNSIGNED,
	CreateDate		DATE,
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID),
     FOREIGN KEY (PositionID) REFERENCES Position (PositionID)
);

-- create table 4: Group
CREATE TABLE `Group`(
	GroupID 		SMALLINT UNSIGNED PRIMARY KEY,
	GroupName 		VARCHAR(50) UNIQUE KEY NOT NULL,
	CreatorID		SMALLINT UNSIGNED NOT NULL,
	CreateDate		DATE,
    FOREIGN KEY (CreatorID) REFERENCES `Account` (AccountID)
);

-- create table 5: GroupAccount
CREATE TABLE GroupAccount (
	GroupID 		SMALLINT UNSIGNED NOT NULL,
	AccountID 		SMALLINT UNSIGNED NOT NULL,
	JoinDate		DATE NOT NULL,
   PRIMARY KEY(GroupID, AccountID),
   FOREIGN KEY (GroupID) REFERENCES `Group` (GroupID)
    
);

-- create table 6: TypeQuestion
CREATE TABLE TypeQuestion (
	TypeID		SMALLINT UNSIGNED PRIMARY KEY,
	TypeName	ENUM ('Essay', 'Multiple-Choice') UNIQUE KEY NOT NULL
);

-- create table 7: CategoryQuestion
CREATE TABLE CategoryQuestion (
	CategoryID		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	CategoryName	VARCHAR(100) UNIQUE KEY NOT NULL
);

-- create table 8: Question
CREATE TABLE Question (
	QuestionID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Content			VARCHAR(100) UNIQUE KEY NOT NULL,
	CategoryID		SMALLINT UNSIGNED NOT NULL,
	TypeID			SMALLINT UNSIGNED NOT NULL,
	CreatorID		SMALLINT UNSIGNED NOT NULL,
	CreateDate		DATE,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion (TypeID),
    FOREIGN KEY (CreatorID) REFERENCES `Account` (AccountID)
    );

-- create table 9: Answer
CREATE TABLE Answer (
	AnswerID 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Content		VARCHAR(100) NOT NULL,
    QuestionID	TINYINT UNSIGNED NOT NULL,
    isCorrect	ENUM ('đúng', 'sai') NOT NULL,
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);


-- create table 10: Exam
CREATE TABLE Exam (
	ExamID	 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`Code`		CHAR(10) UNIQUE KEY NOT NULL,
    Title		VARCHAR(50) NOT NULL,
    CategoryID	SMALLINT UNSIGNED,
    Duration	TINYINT UNSIGNED NOT NULL,
    CreatorID	SMALLINT UNSIGNED NOT NULL,
    CreateDate	DATE NOT NULL,
    FOREIGN KEY (CreatorID) REFERENCES `Account` (AccountID),
    FOREIGN KEY (CategoryID) REFERENCES `CategoryQuestion` (CategoryID)
    
);

-- create table 11: ExamQuestion
CREATE TABLE ExamQuestion (
	ExamID	 	TINYINT UNSIGNED NOT NULL,
	QuestionID	TINYINT UNSIGNED ,
    FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
	FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID),
    PRIMARY KEY (ExamID,QuestionID)
    
);

/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/

INSERT INTO Department  (DepartmentID   , DepartmentName) 
VALUES
						(1,				N'Marketing'		),
						(2,				N'Sale'				),
						(3,				N'Sercurity'		),
						(4,				N'Technical'		),
						(5,				N'Accounting '		),
						(6,				N'Director'			);
                  
INSERT INTO Position   (PositionID,       PositionName)
VALUES
						(1,				'Sale'				),
                        (2,				'Digital marketing'	),
						(3,				'Test'				),
						(4,				'Vice Director'		),
						(5,				'Guard'				),
                        (6,				'Accountant'		);
                        
INSERT INTO  `Account` (AccountID, 		Email, 						User_name, 				Full_name, 			DepartmentID,	PositionID,	CreateDate)
VALUES
						(1,			'duynn03@gmail.com',			'duynn03',				N'Nguyễn Ngọc Duy',		6,				4,			NOW()),
						(2,			'tranphudattp1997@gmail.com',	'dat.tranphu',			N'Trần Phú Đạt',		3,				5,			NULL),
						(3,			'alka.asura@gmail.com',			'du.lengoc',			N'Lê Ngọc Du',			1,				2,			NOW()),
						(4,			'ntd19795@gmail.com',			'duc.nguyenthe',		N'Nguyễn Thế Đức',		5,				6,			NOW()),
						(5,			'Vuhoanghiepnb@gmail.com',		'hiep.vuhoang',			N'Vũ Hoàng Hiệp',		4,				3,			NULL),
						(6,			'mynt2407@gmail.com',			'my.nguyenthi',			N'Nguyễn Thị Mỵ',		2,				1,			NULL),
						(7,			'nhung.tongthi@vti.com.vn',		'nhung.tongthi',		N'Tống Thị Nhung',		1,				2,			NOW());
                        
INSERT INTO `Group` (GroupID, 	GroupName, 				CreatorID, CreateDate)
VALUES 
					(1, 		'nhom_cao_to',			5,			NULL),
					(2, 		'nhom_den_hoi',			7,			now()),
					(3, 		'nhom_xinh_gai',		3,			now()),
					(4, 		'nhom_cute',			1,			now()),
                    (5, 		'nhom_hoc_gioi',		5,			NULL),
                    (6, 		'nhom_hoc_kha',			2,			NULL),
                    (7, 		'nhom_sieu_giau',		1,			now());
                    
INSERT INTO GroupAccount (GroupID,	AccountID, JoinDate)
VALUES 
						(1, 		5,			now()),
						(2, 		4,			now()),
						(3, 		7,			now()),
						(4, 		1,			now()),
                        (5, 		1,			now()),
                        (6, 		3,			now()),
                        (7, 		5,			now());
                        
INSERT INTO TypeQuestion (TypeID, 	TypeName)
VALUES
						(1,			'Essay'),
						(2,			'Multiple-Choice');
                        
INSERT INTO CategoryQuestion 	(CategoryName)
VALUES
								('Java'			),
								('ASP.NET'		),
								('ADO.NET'		),
								('SQL'			);
                                
INSERT INTO Question (Content,									TypeID,						CategoryID, 	CreatorID, CreateDate)
VALUES

					(N'Java là gì',								2,							1,				'2',			'2020-02-11'),
					(N'SQL là gì',								1,							2,				'1',			'2020-02-11'),
                    (N'TINYINT là gì',							1,							3,				'1',			'2020-01-30'),
                    (N'SMALLINT là gì',							2,							4,				'7',			'2020-08-17'),
                    (N'CHAR và VARCHAR giống nhau như thế nÀO',	1,							3,				'3',			'2020-08-20');
                    
INSERT INTO `Answer` (QuestionID,	Content, 							isCorrect)
VALUES
					(1, 			'là ngôn ngữ lập trình',			'đúng'),
                    (2,				'ràng buộc dữ liệu chiếm 1B',		'đúng'),
                    (3, 			'Định dạng chuỗi kí tự',			'sai'),
                    (4, 			'ngôn ngữ truy vấn có cấu trúc',	'đúng'),
                    (5, 			'ràng buộc dữ liệu chiếm 2B',		'sai');
                    
INSERT INTO Exam (`Code`, 	Title, 		Duration, 	CreatorID, CreateDate)
VALUES 
				('E_11',	'Java',		'60', 		1,			'2020-07-01'),
                ('E_13', 	'SQL',		'120', 		3,			'2020-08-03'),
                ('E_15', 	'Web',		'120', 		3,			'2020-08-03'),
                ('E_10', 	'AI',		'90', 		2,			'2020-11-03'),
                ('E_12', 	'Database',	'60', 		7,			'2020-11-11');
INSERT INTO ExamQuestion	(ExamID, QuestionID)
VALUES
							(1, 	3),
                            (4, 	5),
                            (2, 	2),
                            (3, 	3),
                            (1, 	2);