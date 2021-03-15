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
