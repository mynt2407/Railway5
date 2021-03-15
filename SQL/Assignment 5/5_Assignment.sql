
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale

-- cách 1: dùng join và where
DROP VIEW IF EXISTS DANH_SACH_NHAN_VIEN_SALE;
CREATE VIEW	 DANH_SACH_NHAN_VIEN_SALE AS
SELECT  	A.Full_name, D.DepartmentID
FROM 		Department D
JOIN		`Account` A ON A.DepartmentID = D.DepartmentID
WHERE 		D.DepartmentName = 'Sale' ;
 
 SELECT *
FROM DANH_SACH_NHAN_VIEN_SALE;

-- Cách 2: Dùng Sub-Query 
DROP VIEW IF EXISTS DANH_SACH_NHAN_VIEN_SALE_MOI;
CREATE VIEW	 DANH_SACH_NHAN_VIEN_SALE_MOI AS
SELECT  	A.Full_name, D.DepartmentID
FROM 		Department D
JOIN		`Account` A ON A.DepartmentID = D.DepartmentID
WHERE 		D.DepartmentID = (SELECT D.DepartmentID
								FROM Department D
								WHERE D.DepartmentID = 2)
				
;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
-- CÁCH 1:
DROP VIEW IF EXISTS ACCOUNT_THAM_GIA_NHIEU_NHAT;
CREATE VIEW ACCOUNT_THAM_GIA_NHIEU_NHAT AS

SELECT *
FROM  	`Account` A
JOIN	 GroupAccount GA ON A.AccountID = GA.AccountID
GROUP BY GA.AccountID 
HAVING 	 COUNT(GA.AccountID) = (SELECT MAX(SO_LUONG_NHAN_VIEN)
								FROM ( SELECT  COUNT(GA.AccountID) AS SO_LUONG_NHAN_VIEN
										FROM 	`Account` A
										JOIN	 GroupAccount GA ON A.AccountID = GA.AccountID
										GROUP BY GA.AccountID) AS Employee)
;
SELECT *
FROM ACCOUNT_THAM_GIA_NHIEU_NHAT; 

-- CÁCH 2: DÙNG SUBQUERY 
SELECT 	*
FROM 	`Account` A
WHERE 	A.AccountID = (
					SELECT A.AccountID
					FROM `Account` A 
					WHERE A.AccountID  = 4)
;
-- CÁCH 3: DÙNG CTE:
WITH 	MAX_OF_ACCOUNT_JOIN_GROUP AS (
SELECT COUNT(GA.AccountID)
FROM  	`Account` A
JOIN	 GroupAccount GA ON A.AccountID = GA.AccountID
GROUP BY GA.AccountID 
ORDER BY COUNT(GA.AccountID) DESC
LIMIT 	1)

SELECT 		A.*, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		`Account` A 
INNER JOIN 	GroupAccount GA ON A.AccountID = GA.AccountID
GROUP BY	A.AccountID
HAVING		COUNT(GA.AccountID) = (SELECT * FROM MAX_OF_ACCOUNT_JOIN_GROUP);

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 20 từ được coi là quá dài) và xóa nó đi
DROP VIEW IF EXISTS LENGTH_CONTENT;
CREATE VIEW LENGTH_CONTENT AS 
SELECT 	*
FROM 	Question
WHERE 	LENGTH(Content) > 20;

SELECT *
FROM 	LENGTH_CONTENT;

DELETE 
FROM 	LENGTH_CONTENT 
WHERE 	LENGTH(Content) > 20;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
-- Cách 1: Dùng view 

DROP VIEW IF EXISTS MAX_NHAN_VIEN;
CREATE VIEW MAX_NHAN_VIEN AS

SELECT	D.DepartmentID, D.DepartmentName
FROM 	Department D
JOIN 	`Account` A ON A.DepartmentID = D.DepartmentID
GROUP BY A.DepartmentID
HAVING 	COUNT(A.DepartmentID) =  (
									SELECT  	COUNT(DepartmentID)
									FROM 		`Account` A
									GROUP BY	DepartmentID
                                    HAVING 		COUNT(DepartmentID)
                                    ORDER BY 	COUNT(DepartmentID) DESC
									LIMIT 		1)                                                                
;
SELECT *
FROM MAX_NHAN_VIEN;

-- CÁCH 2: DÙNG CTE
WITH 	MAX_LIST_DEPARTMENT AS (
SELECT 	COUNT(A.DepartmentID) AS SO_LUONG_NV_MAX
FROM	Department D
JOIN 	`Account` A ON A.DepartmentID = D.DepartmentID
GROUP BY A.DepartmentID
ORDER BY COUNT(A.DepartmentID) DESC
LIMIT 	1)

SELECT 	* 
FROM 	Department D
JOIN 	`Account` A ON A.DepartmentID = D.DepartmentID
GROUP BY A.DepartmentID
HAVING 	COUNT(A.DepartmentID) = (SELECT * FROM MAX_LIST_DEPARTMENT);

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
DROP VIEW IF EXISTS CREATOR_NGUYEN;
CREATE VIEW CREATOR_NGUYEN AS
SELECT  	 A.Full_name, Q.Content, Q.CreatorID
FROM		 `Account` A 
JOIN 		Question Q ON Q.CreatorID = A.AccountID
WHERE 		A.Full_name LIKE 'Nguyễn%'
;
SELECT *
FROM CREATOR_NGUYEN;

/*====================================== CHỮA BÀI=================== =================== */
-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 20 từ được coi là quá dài) và xóa nó đi
