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

SELECT *
FROM TypeQuestion
WHERE TypeID = @TypeID;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
 -- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
 -- chuỗi của người dùng nhập vào
 
DROP PROCEDURE IF EXISTS tra_ve_chuoi;
USE  testingsystem;
DELIMITER $$
CREATE PROCEDURE tra_ve_chuoi (IN input_ten_nhom VARCHAR(50), IN in_put_ten_user VARCHAR(50)) -- Chỉ cần nhập 1 biến 
BEGIN 
SELECT  GroupName, null AS User_name
FROM 	`Group` G
WHERE 	GroupName LIKE CONCAT('%', input_ten_nhom, '%')
UNION 
SELECT 	 null AS GroupName, User_name 
FROM 	`Account`
WHERE 	User_name LIKE CONCAT('%', in_put_ten_user, '%');
END$$
DELIMITER ;
CALL tra_ve_chuoi ('%cao%','duy');

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



-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
 -- dụng store ở câu 9 để xóa)
 -- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
 
--  Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")




