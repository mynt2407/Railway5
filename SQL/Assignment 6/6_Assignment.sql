-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS INFORMATION;
USE  testingsystem;
DELIMITER $$
CREATE PROCEDURE INFORMATION (IN Ten_phong_ban VARCHAR(50))
BEGIN 
SELECT  A.AccountID 
FROM 	`account` A 
JOIN 	Department D ON D.DepartmentID = A.DepartmentID
WHERE 	D.DepartmentName = Ten_phong_ban;
END$$
DELIMITER ;
CALL INFORMATION ('Marketing');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group

DROP PROCEDURE IF EXISTS SO_ACCOUNT_TRONG_GROUP;
USE  testingsystem;
DELIMITER $$
CREATE PROCEDURE SO_ACCOUNT_TRONG_GROUP ()
BEGIN 
SELECT 		GroupID, COUNT(AccountID) AS SO_LUONG_ACCOUNT
FROM 		Groupaccount
GROUP BY 	AccountID;
END$$
DELIMITER ;
CALL SO_ACCOUNT_TRONG_GROUP ();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại

DROP PROCEDURE IF EXISTS get_type_question_in_month;
USE  testingsystem;
DELIMITER $$
CREATE PROCEDURE get_type_question_in_month ()
BEGIN 
SELECT 	TypeID, COUNT(TypeID) AS SO_LUONG 
FROM 	Question 
WHERE 	MONTH(CreateDate) = MONTH(NOW())
GROUP BY TypeID;
END$$
DELIMITER ;
CALL get_type_question_in_month ();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất 
DROP PROCEDURE IF EXISTS quetionid_max;
DELIMITER $$
CREATE PROCEDURE QuetionID_max (OUT loai_ID SMALLINT UNSIGNED)
BEGIN 
SELECT 		Q.TypeID INTO loai_ID
FROM 		Question Q
JOIN 		TypeQuestion TQ ON Q.TypeID = TQ.TypeID
GROUP BY	Q.TypeID
HAVING 		COUNT(Q.TypeID) = ( SELECT MAX(SO_LUONG)
								FROM 	(SELECT		COUNT(Q.TypeID) AS SO_LUONG
										FROM 		Question Q
										JOIN 		TypeQuestion TQ ON Q.TypeID = TQ.TypeID
										GROUP BY	Q.TypeID) AS TINH_SO_LUONG_MAX);
END$$
DELIMITER ; 
SET @TypeID = 0;
CALL QuetionID_max (@TypeID);
SELECT @TypeID;

-- Cách 2:
DROP FUNCTION IF EXISTS Loai_cau_dai_nhat;
DELIMITER $$
CREATE FUNCTION Loai_cau_dai_nhat () RETURNS SMALLINT UNSIGNED
READS SQL DATA
DETERMINISTIC
BEGIN 
DECLARE 	loai_ID SMALLINT UNSIGNED;

SELECT 		Q.TypeID INTO loai_ID
FROM 		Question Q
JOIN 		TypeQuestion TQ ON Q.TypeID = TQ.TypeID
GROUP BY	Q.TypeID
HAVING 		COUNT(Q.TypeID) = ( SELECT MAX(SO_LUONG)
								FROM 	(SELECT		COUNT(Q.TypeID) AS SO_LUONG
										FROM 		Question Q
										JOIN 		TypeQuestion TQ ON Q.TypeID = TQ.TypeID
										GROUP BY	Q.TypeID) AS TINH_SO_LUONG_MAX);
RETURN loai_ID;
END$$
DELIMITER ; 
SELECT Loai_cau_dai_nhat();

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
-- Gọi theo kiểu Function
SELECT TypeName
FROM TypeQuestion
WHERE TypeID = Loai_cau_dai_nhat();

-- Gọi theo kiểu store
SELECT *
FROM TypeQuestion
WHERE TypeID = @TypeID;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
 -- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
 -- chuỗi của người dùng nhập vào
 
DROP PROCEDURE IF EXISTS tra_ve_chuoi;
DELIMITER $$
CREATE PROCEDURE tra_ve_chuoi (IN input_text VARCHAR(50)) -- Chỉ cần nhập 1 biến 
BEGIN 
SELECT  GroupName, null AS User_name
FROM 	`Group` G
WHERE 	GroupName LIKE CONCAT('%', input_text, '%')
UNION 
SELECT 	 null AS GroupName, User_name 
FROM 	`Account`
WHERE 	User_name LIKE CONCAT('%', input_text, '%');
END$$
DELIMITER ;
CALL tra_ve_chuoi ('duy');

-- Ví dụ: Nhập vào user name, trả ra id của người dùng 
DROP PROCEDURE IF EXISTS out_put_account_id;
USE testingsystem;
DELIMITER $$
CREATE FUNCTION out_put_account_id (ten_nhap_vao VARCHAR(50)) RETURNS SMALLINT UNSIGNED
READS SQL DATA
DETERMINISTIC
BEGIN 
DECLARE AccountID SMALLINT UNSIGNED;
SELECT 	AccountID INTO AccountID
FROM 	`Account`
WHERE 	User_name = ten_nhap_vao;
RETURN 	AccountID;
END$$
DELIMITER ;
SELECT OUT_PUT_ACCOUNT_ID(duynn03);

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công

DROP PROCEDURE IF EXISTS out_put_many_result;
USE testingsystem;
DELIMITER $$
CREATE PROCEDURE out_put_many_result (IN in_put_Full_name VARCHAR(50), IN in_put_Email VARCHAR(50))
BEGIN
DECLARE out_ten_vi_tri TINYINT;
DECLARE out_department TINYINT;

SELECT 	PositionID INTO out_ten_vi_tri
FROM 	`Position`
WHERE 	PositionName = 'Developer';

SELECT	DepartmentID INTO out_department
FROM 	Department
WHERE 	DepartmentName = 'Waitingroom';

INSERT INTO `Account` (Email, 		User_name, 								Full_name, 			DepartmentID,	PositionID)
VALUES
					(in_put_Email, 	SUBSTRING_INDEX(in_put_Email, '@', 1), 	in_put_Full_name, 	out_department,	out_ten_vi_tri);

IF ROW_COUNT() > 0 THEN
	SELECT ' You created recording successfully!';
ELSE 
	SELECT ' You did not created recording successfully!';
END IF;
END$$
DELIMITER ;
call out_put_many_result (N'Nguyễn Thế Hưng', 'hungnguyen@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
 -- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
  
DROP PROCEDURE IF EXISTS type_question_max;
DELIMITER $$ 
CREATE PROCEDURE type_question_max (IN in_type_name ENUM ('Essay', 'Multiple-Choice'))
BEGIN 
DECLARE Noi_dung_cau_hoi VARCHAR(100);

SELECT 		Content INTO Noi_dung_cau_hoi
FROM 		Question
WHERE 		CHAR_LENGTH(Content)  = (SELECT MAX(CHAR_LENGTH(Content)) 
									FROM Question Q
                                    JOIN TypeQuestion TQ ON Q.TypeID = TQ.TypeID
									WHERE TQ.TypeName = in_type_name);

END$$
DELIMITER ; 

CALL type_question_max('Essay');
-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_delete_exam;
DELIMITER $$ 
CREATE PROCEDURE sp_delete_exam (IN exam_id INT)
BEGIN 

DELETE
FROM Exam 
WHERE ExamID = exam_id;

END$$
DELIMITER ; 

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
 -- dụng store ở câu 9 để xóa)
 -- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
 
 DROP PROCEDURE IF EXISTS sp_delete_exam_2;
DELIMITER $$ 
CREATE PROCEDURE sp_delete_exam_2()
BEGIN 
WITH id_delete AS (
	SELECT ExamID
	FROM Exam
	WHERE YEAR(CreateDate) = YEAR(NOW()) - 3
)
	SELECT eq.ExamID AS id_bi_xoa, COUNT(eq.ExamID) AS so_luong_record
	FROM ExamQuestion eq
	JOIN id_delete id ON eq.ExamID = id.ExamID
	GROUP BY eq.ExamID;

    DELETE
	FROM Exam 
	WHERE ExamID IN (SELECT *
					FROM id_delete);

END$$
DELIMITER ; 

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử 
--  dụng store ở câu 9 để xóa)
--  Sau đó in số lượng record đã remove từ các table liên quan trong khi 
--  removing
DROP PROCEDURE IF EXISTS delect_exam;
DELIMITER $$ 
CREATE PROCEDURE delect_exam ()
BEGIN 

DROP TABLE IF EXISTS id_delete;
CREATE TEMPORARY TABLE id_delete(t_exam_id INT NOT NULL) ENGINE=MEMORY;

INSERT INTO id_delete(t_exam_id)
					SELECT 	ExamID
					FROM 	exam
					WHERE CreateDate < DATE_SUB(NOW(), INTERVAL 3 YEAR);

	SELECT eq.ExamID, COUNT(eq.ExamID) AS so_luong
	FROM ExamQuestion eq 
	JOIN id_delete i ON eq.ExamID = i.t_exam_id
	GROUP BY eq.ExamID;

-- WITH id_delete_2 AS (
-- SELECT 	ExamID
-- FROM 	exam
-- WHERE CreateDate < DATE_SUB(NOW(), INTERVAL 3 YEAR))

-- 	select *
-- 	from id_delete;
	DELETE
	FROM Exam 
	WHERE ExamID IN (SELECT *
					FROM id_delete);

END$$
DELIMITER ; 
    
-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng 
--  nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được 
--  chuyển về phòng ban default là phòng ban chờ việc    
-- input: ten phong 
DROP PROCEDURE IF EXISTS delete_department;
DELIMITER $$ 
CREATE PROCEDURE delete_department (IN department_name VARCHAR(50))
BEGIN 

DECLARE department_id1 INT;
DECLARE department_id2 INT;

SELECT DepartmentID INTO department_id1
FROM Department 
WHERE DepartmentName = department_name;

SELECT DepartmentID INTO department_id2
FROM Department
WHERE DepartmentName = 'Waiting room';

UPDATE `Account`
SET DepartmentID = department_id2
WHERE DepartmentID = department_id1;

DELETE 
FROM `Account`
WHERE DepartmentID = department_id1;

END$$
DELIMITER ; 
 	
 
--  Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
DROP PROCEDURE IF EXISTS question_in_year;
DELIMITER $$ 
CREATE PROCEDURE question_in_year()
BEGIN 

WITH question1 AS(
	SELECT *
    FROM question
    WHERE YEAR(NOW()) = YEAR(CreateDate)
)
SELECT month_in_year.MONTH, COUNT(q.QuestionID)
	FROM (
	SELECT 1 AS MONTH
	UNION SELECT 2 AS MONTH
	UNION SELECT 3 AS MONTH
	UNION SELECT 4 AS MONTH
	UNION SELECT 5 AS MONTH
	UNION SELECT 6 AS MONTH
	UNION SELECT 7 AS MONTH
	UNION SELECT 8 AS MONTH
	UNION SELECT 9 AS MONTH
	UNION SELECT 10 AS MONTH
	UNION SELECT 11 AS MONTH
	UNION SELECT 12 AS MONTH) AS month_in_year
LEFT JOIN question1 q ON  month_in_year.MONTH = MONTH(q.CreateDate)
GROUP BY month_in_year.MONTH;
END$$
DELIMITER ; 



