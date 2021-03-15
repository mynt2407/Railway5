-- Question 2: Query all the trainees who is passed the entry test, group them into different birth months
SELECT 		GROUP_CONCAT(Full_Name), GROUP_CONCAT(YEAR(Birth_Date), '-', MONTH(Birth_Date))
FROM		`Trainee table`
GROUP BY 	MONTH(Birth_Date), YEAR(Birth_Date);
 
 -- Question 3: Query the trainee who has the longest name
 SELECT *
 FROM `Trainee table`
 WHERE CHAR_LENGTH(Full_Name) = (SELECT (MAX(CHAR_LENGTH(Full_Name)))
								FROM `Trainee table`);
                                
-- Question 4: Query all the ET-passed trainees. One trainee is considered as ET-passed when he/she has the entry test points satisfied below criteria:
--  ET_IQ + ET_Gmath>=20
--  ET_IQ>=8
--  ET_Gmath>=8
--  ET_English>=18

SELECT *
FROM `Trainee table`
WHERE ET_IQ >= 8 AND ET_Gmath >= 8 AND ET_English >= 18 AND (ET_IQ + ET_Gmath >= 20)
;

-- Question 5: Delete information of trainee who has TraineeID = 3
DELETE 
FROM `Trainee table`
WHERE TraineeID = 3;

-- Question 6: trainee who has TraineeID = 5 move "2" class. Let update information into database
UPDATE `Trainee table`
SET 	Training_Class = 2
WHERE	TraineeID = 5;
