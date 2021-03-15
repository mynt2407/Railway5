DROP PROCEDURE IF EXISTS xoa_Account;
USE  testingsystem;
DELIMITER $$
CREATE PROCEDURE xoa_Account (IN Ma_phong_ban VARCHAR(50))
BEGIN 
DELETE  
FROM 	`account` 
WHERE 	DepartmentID = Ma_phong_ban;
END$$
DELIMITER ;
-- CALL xoa_Account (3);
