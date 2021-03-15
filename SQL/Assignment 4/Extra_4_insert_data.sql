/*============================== INSERT DATA =======================================*/
/*======================================================================================*/

INSERT INTO 	Department 	(Department_Number, Department_Name	)
VALUES			
							(1,					'Sale'			),
							(2,					'Marketing'		),
							(3,					'Accounting'	),
							(4,					'Purchasing'	),
							(5,					'Human_resources');
                            
INSERT INTO Employee_Table (Employee_Name, 			Department_Number)
VALUES						
							(N'Nguyễn Thị Mai',	 	2),
                            (N'Trần Văn Nam',		4),
                            (N'Nguyễn Khánh Linh',	2),
                            (N'Nguyễn Ngọc Duy',	1),
                            (N'Phạm Diệu Ngọc', 	5);
                            
INSERT INTO Employee_Skill_Table (Employee_Number, Skill_Code, Date_Registered)
VALUES						
								 (3,	 			'SQL', 		NULL),
								 (2,	 			'PHP', 		now()),
                                 (2,	 			'C++', 		NULL),
                                 (5,	 			'AI', 		now()),
                                 (1,	 			'Java', 	now());
							
                            
                            