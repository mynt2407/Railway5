
-- Trigger
DROP TRIGGER IF EXISTS validate_create_time;
DELIMITER $$
CREATE TRIGGER validate_create_time

BEFORE INSERT ON Question
FOR EACH ROW
BEGIN

IF NEW.`CreateDate` > NOW() THEN
SET NEW.CreateDate = NOW();
	-- SIGNAL SQLSTATE '12345'
-- 	SET MESSAGE_TEXT = 'Can not insert this record';
END IF;

END $$
DELIMITER ;

INSERT INTO Question (Content,											TypeID,						CategoryID, 	CreatorID, 		CreateDate)
VALUES

					(N'Không được insert ',										2,							1,					2,			'2025-02-11 01:20:00');

-- Case when
SELECT QuestionID,
CASE 
	WHEN Title IS NULL THEN 'Khong co tieu de'
    ELSE Title
    
END as title
FROM testingsystem.question;
                    