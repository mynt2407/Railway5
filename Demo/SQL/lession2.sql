SELECT * 
FROM testingsystem.account
WHERE AccountID > 2 AND AccountID < 6;
WHERE AccountID BETWEEN 3 AND 5; 
WHERE User_name like 'duynn%'
WHERE AccountID = 2 OR AccountID = 5
WHERE AccountID NOT IN (2, 5)

-- ORDER BY

SELECT * 
FROM testingsystem.account
ORDER BY User_name ASC, Full_name DESC
