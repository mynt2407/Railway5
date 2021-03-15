-- Question 3: Query all Employee (include: name) who has Java skill
SELECT ET.Employee_Number, ET.Employee_Name, EST.Skill_Code
FROM Employee_Table ET
JOIN Employee_Skill_Table EST ON ET.Employee_Number = EST.Employee_Number
HAVING Skill_Code = 'Java';

-- Question 4: Query all department which has >= 2 employee
SELECT 		D.Department_Name, COUNT(ET.Department_Number) AS SO_LUONG_NHAN_VIEN
FROM 		Department D
JOIN 		Employee_Table ET ON D.Department_Number = ET.Department_Number
GROUP BY 	ET.Department_Number
HAVING 		COUNT(ET.Employee_Number) >= 2
;

-- Question 5: Query all employee of each department. 
SELECT 		ET.Department_Number, D.Department_Name, COUNT(ET.Employee_Number) AS SO_LUONG_NHAN_VIEN
FROM 		Department D
LEFT JOIN 	Employee_Table ET ON D.Department_Number = ET.Department_Number
GROUP BY 	ET.Department_Number
;
