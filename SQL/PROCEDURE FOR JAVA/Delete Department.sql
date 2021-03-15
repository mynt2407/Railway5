DROP PROCEDURE IF EXISTS xoa_Department;
USE  testingsystem;
DELIMITER $$
CREATE PROCEDURE xoa_Department (IN Ma_phong_ban VARCHAR(50))
BEGIN 
DELETE  
FROM 	Department 
WHERE 	DepartmentID = Ma_phong_ban;
END$$
DELIMITER ;
-- CALL xoa_Department (3);