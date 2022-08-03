DROP PROCEDURE IF EXISTS get_department;
USE  testingsystem;
DELIMITER $$
CREATE PROCEDURE get_department (IN department_id INT, OUT out_department_name VARCHAR(50))
BEGIN 
SELECT   d.DepartmentName INTO out_department_name
FROM 	Department d
WHERE 	d.DepartmentID = department_id;
END$$S
DELIMITER ;
-- Nếu không cần sử dụng logic tiếp theo thì ko cần khai báo biến output
CALL get_department(1);

-- USE
SET @department_name = '';
CALL get_department(3, @department_name);

SELECT @department_name;


DROP FUNCTION IF EXISTS f_department_name;
DELIMITER $$
CREATE FUNCTION f_department_name(department_id INT) RETURNS VARCHAR(50)
READS SQL DATA
DETERMINISTIC
BEGIN
 
DECLARE 	d_name  VARCHAR(50);
SELECT   d.DepartmentName INTO d_name
FROM 	Department d
WHERE 	d.DepartmentID = department_id;

RETURN d_name;
END$$
DELIMITER ; 
SELECT f_department_name();

SELECT DAY(now());

DELETE 
FROM Question
WHERE QuestionID = 1;