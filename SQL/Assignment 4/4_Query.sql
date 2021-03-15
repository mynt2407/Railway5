/*====================Exercise 1: Join====================*/

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 	A.Full_name, A.User_name, A.Email, A.CreateDate, D.DepartmentName, D.DepartmentID 
FROM 	`Account` A
JOIN 	`Department` D ON D.DepartmentID = A.DepartmentID
;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010 
SELECT 	*
FROM 	`Account`
WHERE 	CreateDate > '2010-12-20'
;

-- Question 3: Viết lệnh để lấy ra thông tin của tất cả các Developer 
SELECT 	*
FROM 	`Account` A
JOIN 	Position P ON P.PositionID = A.PositionID
WHERE 	PositionName = 'Developer'
 ;

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên

SELECT 		D.DepartmentName, COUNT(A.AccountID) AS 'So luong nhan vien'
FROM 		`Account` A
JOIN 		Department D ON A.DepartmentID = D.DepartmentID
GROUP BY 	A.DepartmentID
HAVING 		COUNT(A.AccountID) > 2;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất

SELECT 		Q.QuestionID -- , COUNT(EQ.ExamID), GROUP_CONCAT(EQ.ExamID)
FROM 		Question Q
LEFT JOIN	Examquestion EQ ON EQ.QuestionID = Q.QuestionID
GROUP BY	Q.QuestionID
HAVING 		COUNT(EQ.ExamID) = (SELECT Max(So_Luong_Exam) 
								FROM  ( SELECT 		COUNT(EQ.ExamID) AS So_Luong_Exam
										FROM 		Question Q
										LEFT JOIN	Examquestion EQ ON EQ.QuestionID = Q.QuestionID
										GROUP BY	Q.QuestionID) AS statistic_Question_Exam);
                                        
 
 -- Question 6: Thống kê mỗi category Question được sử dụng trong bao nhiêu Question
 SELECT 	CategoryName, Q.CategoryID, GROUP_CONCAT(Q.QuestionID) AS CAU_HOI
 FROM 		CategoryQuestion C
 JOIN 		Question Q ON C.CategoryID = Q.CategoryID
 GROUP BY	Q.CategoryID
 ;
 
 -- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
 SELECT		EQ.ExamID, EQ.QuestionID, COUNT(EQ.QuestionID), GROUP_CONCAT(EQ.QuestionID) AS SO_LUONG_EXAM 
 FROM 		Question Q
 JOIN 		ExamQuestion EQ ON Q.QuestionID = EQ.QuestionID
 GROUP BY 	EQ.QuestionID
 ;
 
 -- Question 8: Lấy ra Question có nhiều câu trả lời nhất
 
 SELECT 	Q.QuestionID, A.AnswerID
 FROM		Question Q
 LEFT JOIN 	Answer A ON Q.QuestionID = A.QuestionID
 GROUP BY	A.QuestionID
 HAVING 	COUNT(A.AnswerID) = (SELECT MAX(CAU_TRA_LOI) 
									FROM  	(SELECT COUNT(A.AnswerID) AS CAU_TRA_LOI
											FROM Question Q
											LEFT JOIN Answer A ON Q.QuestionID = A.QuestionID
											GROUP BY A.QuestionID) AS MAX_CAU_TRA_LOI)
 ;
 
 -- Question 9: Thống kê số lượng account trong mỗi group 
 SELECT 	GA.GroupID, COUNT(GA.AccountID) AS SO_LUONG_ACCOUNT
 FROM 		`Group` G
 LEFT JOIN 	GroupAccount GA ON G.GroupID = GA.GroupID
 GROUP BY 	GA.GroupID
 ;
 
 -- Question 10: Tìm chức vụ có ít người nhất
 
 SELECT 	P.PositionID, P.PositionName, COUNT(A.AccountID) AS SO_NGUOI
 FROM 		Position P
 JOIN 		`Account` A ON P.PositionID = A.PositionID
 GROUP BY	A.PositionID
 HAVING		COUNT(A.AccountID) = 	(SELECT MIN(SO_LUONG_NHAN_VIEN)
									FROM  	(SELECT 	COUNT(A.AccountID) AS SO_LUONG_NHAN_VIEN
											FROM 		Position P 
											JOIN		`Account` A ON P.PositionID = A.PositionID
											GROUP BY	A.PositionID) AS MIN_NHAN_VIEN)
;

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, 
SELECT	Q.QuestionID, Q.CategoryID, CG.CategoryName, Q.Content AS CAU_HOI, Q.CreatorID, A.Content AS CAU_TRA_LOI
FROM 	Question Q
JOIN 	Answer A ON Q.QuestionID = A.QuestionID
JOIN 	CategoryQuestion CG ON CG.CategoryID = Q.CategoryID
;

 -- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT 		TypeName, COUNT(Q.TypeID) AS SO_LUONG_CAU_HOI
FROM 		TypeQuestion TQ
JOIN 		Question Q ON TQ.TypeID = Q.TypeID
GROUP BY 	Q.TypeID
;

 -- Question 14:Lấy ra group không có account nào
SELECT 		*
FROM 		GroupAccount GA
RIGHT JOIN `Group` G ON G.GroupID = GA.GroupID
WHERE 		GA.GroupID IS NULL
;
 
 -- Question 16: Lấy ra question không có answer nào
 SELECT Q.QuestionID
 FROM Question Q
 LEFT JOIN `Answer` A ON Q.QuestionID = A.QuestionID
 WHERE A.QuestionID IS NULL;
 
 --- Exercise 2: `Union`
--  Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
-- b) Lấy các account thuộc nhóm thứ 2
-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau

SELECT 		A.AccountID, Full_name
FROM 		GroupAccount GA
JOIN 		`Account` A ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 1
UNION
SELECT 		A.AccountID, Full_name
FROM 		GroupAccount GA
JOIN 		`Account` A ON A.AccountID = GA.AccountID
WHERE 		GA.GroupID = 3
;

-- Question 18:
-- a) Lấy các group có lớn hơn >= 2 thành viên
-- b) Lấy các group có nhỏ hơn 7 thành viên
-- c) Ghép 2 kết quả từ câu a) và câu b)

SELECT 		G.GroupID, G.GroupName,COUNT(GA.AccountID) AS SO_THANH_VIEN
FROM 		`Group` G
JOIN 		GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY 	G.GroupID
HAVING 		COUNT(GA.AccountID) >= 2
UNION 	
SELECT 		G.GroupID, G.GroupName,COUNT(GA.AccountID) AS SO_THANH_VIEN
FROM 		`Group` G
JOIN 		GroupAccount GA ON G.GroupID = GA.GroupID
GROUP BY 	G.GroupID
HAVING 		COUNT(GA.AccountID) < 7
;