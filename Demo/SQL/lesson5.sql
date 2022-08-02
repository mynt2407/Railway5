-- View 
DROP VIEW IF EXISTS query_example;

CREATE VIEW  query_example AS
SELECT  d.DepartmentID, d.DepartmentName, p.PositionID, p.PositionName, COUNT(a.AccountID) AS so_luong
FROM Department d
CROSS JOIN Position p
JOIN `Account` a ON a.DepartmentID = d.DepartmentID AND a.PositionID = p.PositionID
WHERE p.PositionName IN ('dev', 'Test', 'Scrum Master', 'PM')
GROUP BY d.DepartmentID, p.PositionID
ORDER BY d.DepartmentID, p.PositionID;

SELECT *
FROM query_example;

DELETE 
FROM query_example
WHERE so_luong >=2;

UPDATE query_example
SET DepartmentName = 'ABC'
WHERE DepartmentName = 'Marketing';

-- Sub Query 
SELECT *
FROM Department D1
WHERE D1.Departmentid = (SELECT d2.DepartmentID
						FROM Department d2
                        WHERE d2.DepartmentName = 'Marketing');
                        

-- Demo IN Operator
SELECT *
FROM `Account` a1
WHERE a1.DepartmentID IN  (SELECT a2.DepartmentID
						FROM `Account` a2
                        WHERE a2.DepartmentID = 1);
                        
-- Demo ALL : !=, >
SELECT *
FROM `Account` a1
WHERE a1.DepartmentID > ALL (SELECT a2.DepartmentID
						FROM `Account` a2
                        WHERE a2.DepartmentID = 2 OR a2.DepartmentID = 3);
 
 -- Demo SOME: !=, >, =
SELECT *
FROM `Account` a1
WHERE a1.DepartmentID > SOME (SELECT a2.DepartmentID
						FROM `Account` a2
                        WHERE a2.DepartmentID = 3 OR a2.DepartmentID = 6);
                        
SELECT *
FROM Question q1
WHERE EXISTS (SELECT q2.QuestionID
						FROM Question q2
                        WHERE q2.CategoryID = 2);


-- VÍ dụ                        
SELECT *
FROM `Account` a1
WHERE a1.PositionID > SOME (SELECT a2.PositionID
						FROM `Account` a2
                        WHERE a2.PositionID = 3 OR a2.PositionID = 2);
                        
-- CTE 
WITH id_phong_ban AS (
SELECT DepartmentID
FROM Department 
WHERE DepartmentName = 'Marketing')

SELECT *
FROM id_phong_ban;