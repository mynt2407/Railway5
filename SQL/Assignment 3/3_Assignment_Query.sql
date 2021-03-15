/*============================== Query data =======================================*/
/*======================================================================================*/

-- Question 1: 

-- Question 2: Lấy ra tất cả các phòng ban
SELECT * 
FROM department;

-- Question 3: Lấy ra Id của phòng ban sale
SELECT 	DepartmentID
FROM 	Department 
WHERE 	DepartmentName LIKE 'Sale';

-- Question 4: : lấy ra thông tin account có full name dài nhất
SELECT 	*
FROM 	`Account`
WHERE 	CHAR_LENGTH(Full_name) = (
								SELECT MAX(CHAR_LENGTH(Full_name))
								FROM `Account`
						  ); 

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT *
FROM `Account`
WHERE DepartmentID = 3 AND CHAR_LENGTH(Full_name) = (
								SELECT MAX(CHAR_LENGTH(Full_name))
								FROM `Account`
                                WHERE DepartmentID = 3)
; 

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT 	GroupName
FROM 	`Group`
WHERE 	CreateDate < '2019-12-20';

-- Question 7: Lấy ra ID của question có >= 2 câu trả lời
SELECT 		QuestionID, GROUP_CONCAT(AnswerID SEPARATOR '.') AS 'so_lương' -- LIỆT KÊ CỤ THỂ SỐ LƯỢNG, KO CHỈ THỐNG KÊ NHƯ COUNT
FROM 		Answer
GROUP BY 	QuestionID
HAVING 		COUNT(AnswerID) >= 2;	

-- Question 8: Lấy ra các mã đề thi có thời gian thi > 60 phút và được tạo trước ngày 20/12/2019
SELECT *
FROM Exam 
WHERE Duration > '60' AND CreateDate < '2019-12-20';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT *
FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(DepartmentID)
FROM `Account`
WHERE DepartmentID = 2;


-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT *
FROM `Account`
WHERE Full_name LIKE '%D%o';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE
FROM `ExamQuestion`
WHERE ExamID IN (SELECT ExamID
				FROM `Exam`
				WHERE CreateDate < '2019-12-20');
           
DELETE
FROM `Exam`
WHERE CreateDate < '2019-12-20';

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "r%
DELETE
FROM 	Question
WHERE 	Content LIKE 'r%';

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE 	`Account`
SET 	Full_name = "Nguyễn Bá Lộc",
		Email = "loc.nguyenba@vti.com.vn"
WHERE 	AccountID = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE `GroupAccount`
SET 	AccountID = '5'
WHERE 	GroupID = '4';

