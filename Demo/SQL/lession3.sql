-- COUNT, SUM, MIN, MAX, AVG
SELECT DISTINCT Full_name
FROM `account`;

SELECT COUNT(*)
FROM `account`
WHERE DepartmentID = 3;

SELECT MIN(AccountID)
FROM `account`
WHERE DepartmentID = 3;

SELECT SUM(AccountID)
FROM `account`
WHERE DepartmentID = 3;

-- Group By, having
SELECT DepartmentID, COUNT(*)
FROM `account`
GROUP BY DepartmentID
HAVING DepartmentID > 5;

-- update data
UPDATE 	`Account`
SET 	Full_name = 'Thanh Mai Trần'
WHERE 	AccountID = 4;

-- delete data
DELETE
FROM `Account`
WHERE User_name = 'duynn03';
