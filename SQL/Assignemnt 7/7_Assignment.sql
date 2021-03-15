-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
--  trước 1 năm trước
DROP TRIGGER IF EXISTS not_duplicate_date;
DELIMITER $$
CREATE TRIGGER not_duplicate_date
BEFORE INSERT ON `Group`
FOR EACH ROW
BEGIN

DECLARE input_create_date DATETIME;
SELECT NEW.CreateDate INTO input_create_date;

IF input_create_date < (SELECT DATE_ADD(now(), INTERVAL -1 YEAR)) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = ' Ngày tạo không hợp lệ';
END IF;
END $$
DELIMITER ;

INSERT INTO `Group` (GroupName, 		CreatorID, CreateDate)
VALUES 
					('ABC',				2,			'2018-08-15 12:20:20');

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
--  department "Sale" nữa, khi thêm thì hiện ra thông báo "Department Sale cannot add more user"

DROP TRIGGER IF EXISTS except_department_sale;
DELIMITER $$
CREATE TRIGGER except_department_sale
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN

DECLARE input_dept TINYINT UNSIGNED;

SELECT 	DepartmentID INTO input_dept
FROM 	Department
WHERE 	DepartmentName = 'Sale' = NEW.DepartmentName ;

IF input_dept = 2 THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = ' Department Sale cannot add more user';
END IF;
END $$
DELIMITER ;

INSERT INTO  `Account` (Email, 					User_name, 				Full_name, 			DepartmentID)
VALUES
						('hungbeo@gmail.com',	'anhchangdeptrai',		N'Nguyễn Thế Hưng', 2		);		

-- Question 3: Cấu hình 1 group có nhiều nhất là 3 user

DROP TRIGGER IF EXISTS No_in_group;
DELIMITER $$
CREATE TRIGGER No_in_group
BEFORE INSERT ON `GroupAccount`
FOR EACH ROW
BEGIN

DECLARE so_luong_nguoi SMALLINT UNSIGNED;

SELECT COUNT(AccountID) INTO so_luong_nguoi
FROM 	GroupAccount
WHERE	GroupID = NEW.GroupID;

IF  so_luong_nguoi = 3 THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Group full';
END IF;
END $$
DELIMITER ;

INSERT INTO GroupAccount (GroupID, 	AccountID, JoinDate)
VALUES 					  (2, 		4,			now());

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 3 Question
DROP TRIGGER IF EXISTS create_question;
DELIMITER $$
CREATE TRIGGER create_question
BEFORE INSERT ON `ExamQuestion`
FOR EACH ROW
BEGIN

DECLARE input_question TINYINT UNSIGNED;

SELECT COUNT(ExamID) INTO input_question
FROM 	ExamQuestion
WHERE	ExamID = NEW.ExamID;

IF  input_question = 3 THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Can not add more question';
END IF;
END $$
DELIMITER ;

INSERT INTO ExamQuestion	(ExamID, QuestionID)
VALUES						(1, 		4);

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
--  admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
--  còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
--  tin liên quan tới user đó

DROP TRIGGER IF EXISTS delete_email_trigger;
DELIMITER $$
CREATE TRIGGER delete_email_trigger
BEFORE DELETE ON `Account`
FOR EACH ROW 
BEGIN 

DECLARE delete_email VARCHAR(50);
SELECT OLD.Email INTO delete_email;

IF delete_email LIKE 'admin@gmail.com' THEN 
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Không thể xóa được';
END IF;
END $$
DELIMITER ;

DELETE 
FROM `Account`
WHERE Email = 'admin@gmail.com';

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
--  Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
--  vào departmentID thì sẽ được phân vào phòng ban "Waiting Department"

DROP TRIGGER IF EXISTS not_dpt_trigger;
DELIMITER $$
CREATE TRIGGER not_dpt_trigger
BEFORE INSERT ON `Account`
FOR EACH ROW 
BEGIN 

DECLARE input_departmen_id TINYINT UNSIGNED;
SELECT NEW.DepartmentID INTO input_departmen_id;

IF input_departmen_id IS NULL THEN 
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Waiting Department';
END IF;
END $$
DELIMITER ;

INSERT INTO  `Account` (Email, 					User_name, 				Full_name, 				DepartmentID) 			
VALUES
						('thanhhung@gmail.com',	'thanhhung',			N'Nguyễn Thành Hưng',	 NULL);				

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
--  question, trong đó có tối đa 2 đáp án đúng

DROP TRIGGER IF EXISTS create_exam;
DELIMITER $$
CREATE TRIGGER create_exam
BEFORE INSERT ON `Answer`
FOR EACH ROW
BEGIN

DECLARE No_of_answers TINYINT UNSIGNED;
DECLARE No_of_correct_answers TINYINT UNSIGNED;

SELECT 	COUNT(QuestionID) INTO No_of_answers
FROM 	Answer
WHERE  	QuestionID = NEW.QuestionID;

SELECT 	COUNT(QuestionID) INTO No_of_correct_answers
FROM 	Answer
WHERE  	QuestionID = NEW.QuestionID AND isCorrect = 'đúng';

IF  No_of_answers >= 4 OR No_of_correct_answers >= 2 THEN
	SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT = 'Can not add more answers';
END IF;
END $$
DELIMITER ;

INSERT INTO `Answer` (QuestionID,	Content, 							isCorrect)
VALUES
					(3, 			'là ngôn ngữ lập trình',			'đúng');

-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
--  Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
--  Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database

DROP TRIGGER IF EXISTS update_data;
DELIMITER $$
CREATE TRIGGER update_data
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN

DECLARE input_gender VARCHAR(50);
SELECT NEW.Gender INTO input_gender;

IF NEW.Gender = 'Nam' THEN 
SET NEW.Gender = 'M';
END IF;

IF NEW.Gender = 'Nữ' THEN 
SET NEW.Gender = 'F';
END IF;

IF NEW.Gender = 'chưa xác định' THEN 
SET NEW.Gender = 'U';
END IF;

END $$
DELIMITER ;

INSERT INTO  `Account` (Email, 						User_name, 			Full_name, 				 Gender	)
VALUES
						('admin123@gmail.com',		'duyngocnguyen',	N'Trần Ngọc Duy',		'chưa xác định');

SELECT *
FROM 	`Account`;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày

DROP TRIGGER IF EXISTS delete_exam;
DELIMITER $$
CREATE TRIGGER delete_exam
BEFORE DELETE ON `Exam`
FOR EACH ROW
BEGIN

DECLARE create_date DATETIME;
SELECT OLD.CreateDate INTO create_date;

IF create_date > (SELECT DATE_ADD(now(), INTERVAL -2 DAY)) THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Can not delete exam';
END IF;

END $$
DELIMITER ;

DELETE 
FROM Exam
WHERE CreateDate = '2020-09-15';

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
--  question khi question đó chưa nằm trong exam nào

-- DELETE
DROP TRIGGER IF EXISTS delete_update_question;
DELIMITER $$

CREATE TRIGGER delete_update_question
BEFORE DELETE ON `Question`
FOR EACH ROW
BEGIN

DECLARE Exam_Amout TINYINT UNSIGNED;
SELECT OLD.QuestionID INTO Exam_Amout;

SELECT 	COUNT(1) INTO Exam_Amout
FROM 	Question Q
JOIN	 ExamQuestion EQ ON EQ.QuestionID = Q.QuestionID
WHERE	 Q.QuestionID = OLD.QuestionID;

IF Exam_Amout > 0  THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Can not delete';
END IF;

END $$
DELIMITER ;

DELETE 
FROM Question
WHERE QuestionID = '2';

-- UPDATE
DROP TRIGGER IF EXISTS update_question;
DELIMITER $$

CREATE TRIGGER update_question
BEFORE UPDATE ON `Question`
FOR EACH ROW
BEGIN

DECLARE Question_Amout TINYINT UNSIGNED;
SELECT OLD.QuestionID INTO Question_Amout;

SELECT 	COUNT(1) INTO Question_Amout
FROM 	Question Q
JOIN	 ExamQuestion EQ ON EQ.QuestionID = Q.QuestionID
WHERE	 Q.QuestionID = OLD.QuestionID;

IF Question_Amout > 0  THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = 'Can not update';
END IF;

END $$
DELIMITER ;

UPDATE	Question
SET 	QuestionID = 2
WHERE 	QuestionID = 4;

-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"

SELECT Duration,
CASE 
	WHEN 	Duration <= 30 THEN 'Short time'
	WHEN 	Duration <= 60 THEN 'Medium time'
	ELSE 	'Long time'
END	AS 	thoi_gian_thi
FROM 	Exam
GROUP BY Duration;

-- Bài ví dụ
DROP TRIGGER IF EXISTS check_email_trigger;
DELIMITER $$
CREATE TRIGGER check_email_trigger
BEFORE INSERT ON `Account`
FOR EACH ROW 
BEGIN 
-- get email from username
DECLARE input_email VARCHAR(50);
SELECT NEW.Email INTO input_email;

-- check email
IF input_email NOT LIKE '%gmail.com' THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = ' Email không hợp lệ';
END IF;

-- Check user
IF NEW.User_name NOT LIKE '%1' THEN 
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = ' Email không hợp lệ';
END IF;
END $$
DELIMITER ;

INSERT INTO  `Account` (AccountID, 		Email, 						User_name, 				Full_name, 			DepartmentID,	PositionID)
VALUES
						(1,			'nguyenthehung',				'hungnguyen',				N'Nguyễn Thế Hưng',		1,			4);
                        
-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
--  là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher

SELECT 		GroupID, COUNT(AccountID) AS so_luong_user, GROUP_CONCAT(AccountID)
FROM 		GroupAccount
GROUP BY 	GroupID
;
ALTER TABLE GroupAccount
ADD the_number_user_amount TINYINT UNSIGNED;

SELECT the_number_user_amount,
CASE 
	WHEN 	so_luong_user <= 5 THEN 'Few'
	WHEN 	so_luong_user <= 20 THEN 'Normal'
	ELSE 	'High'
END	AS 	so_nv
FROM 	GroupAccount
GROUP BY so_luong_user;

