/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/

INSERT INTO `Trainee table` (Full_Name, 			Birth_Date, 		Gender, 	ET_IQ , 	ET_Gmath, 	ET_English, 	Training_Class )
VALUES
								(N'Trần Phú Đạt',	'2001-03-01',		'Male', 	105,		8, 			33,			 	3),
								(N'Lê Ngọc Du', 	'1996-11-08',		'Male', 	120, 		17,		 	10, 			2),
								(N'Tống Thị Nhung',	'1998-11-11',		'Female', 	115, 		1, 			25, 			9),
								(N'Vũ Văn Ước',	 	'2001-03-01',		'Male', 	101, 		15, 		45, 			1),
                                (N'Nguyễn Thị Mỵ',	'1995-03-01',		'Female', 	107, 		2, 			25, 			3);
                                
INSERT INTO `Data Types`(`Name`, 			`Code`, 		`ModifiedDate`)
VALUES 
						('Interger', 		'INT01', 		now()),
                        ('String', 			'CHAR1', 		now()),
                        ('Money', 			'MNY01', 		now()),
                        ('Date and time',	'DATE1', 		now()),
                        ('ENUM', 			'ENUM1', 		now());
                        
INSERT INTO `Data Types (2)` (`Name`, 				BirthDate, 		IsDeletedFlag)
VALUES 
							(N'Nguyễn Văn An', 		'1995-01-01', 	'1'),
							(N'Nguyễn Mạnh Hoàng', 	'1999-05-01', 	'0'),
                            (N'Nguyễn Khánh Linh',	'2000-10-01', 	'0'),
                            (N'Trần Thành Nam', 	'1998-12-11', 	'1'),
							(N'Trần Thị Hoa', 		'2010-08-12', 	'1');
                            