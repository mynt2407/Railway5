-- COUNT, SUM, MIN, MAX, AVG

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
HAVING DepartmentID > 5
