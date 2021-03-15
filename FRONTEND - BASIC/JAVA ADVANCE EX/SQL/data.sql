/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/

INSERT INTO  `Account` (account_id, 	user_name, 		email, 							`password`, 	full_name)
VALUES
						(1,			'duynn03',			'duynn03@gmail.com',			"123456789",	N'Nguyễn Ngọc Duy'),
						(2,			'dat.tranphu',		'tranphudattp1997@gmail.com',	"123456789",	N'Trần Phú Đạt'),
                        (3,			'du.lengoc',		'alka.asura@gmail.com',			"123456789",	N'Lê Ngọc Du'),
                        (4,			'duc.nguyenthe',	'ntd19795@gmail.com',			"123456789",	N'Nguyễn Thế Đức'),
                        (5,			'hiep.vuhoang',		'Vuhoanghiepnb@gmail.com',		"123456789",	N'Vũ Hoàng Hiệp'),
                        (6,			'my.nguyenthi',		'mynt2407@gmail.com',			"123456789",	N'Nguyễn Thị Mỵ'),
                        (7,			'nguyen.haidang',	'haidang@vti.com.vn',			"123456789",	N'Nguyễn Hải Đăng'),
						(8,			'toan.nguyen',		'toan@vti.com.vn',				"123456789",	N'Nguyễn Văn Toàn'),
						(9,			'tong.nhung',		'nhungtong@vti.com.vn',			"123456789",	N'Tống Thị Nhung'),
						(10,		'haiha.le',			'Lehaiha@vti.com.vn',			"123456789",	N'Lê Hải Hà'),
						(11,		'thanhhung',		'hung.nguyen@vti.com.vn',		"123456789",	N'Nguyễn Thành Hưng');
     
INSERT INTO  `Group` (group_id, 	group_name, 		 `member` , creator_id, create_date)
VALUES
						(1,			'Java Core',		2, 			4, 			'2019-01-10 10:11:11'),
						(2,			'Group C#',			15, 		6, 			now()),
                        (3,			'My SQL',			23, 		1,			'2020-09-20 01:15:30'),
                        (4,			'Frontend basic',	12, 		3, 			now()),
                        (5,			'Frontend Advance',	30, 		7, 			now()),
                        (6,			'Java Advance',		2, 			2,			'2018-02-11 09:50:11'),	
                        (7,			'Group PHP',		60, 		4, 			'2018-02-10 03:20:11'),
                        (8,			'React Js',			45, 		10, 		'2018-05-11 08:40:20'),
                        (9,			'JavaScript',		30, 		11, 		'2019-02-11 05:45:13'),
                        (10,		'Group AI',			23, 		8, 			'2020-02-10 09:33:10'),
                        (11,		'SQL Server',		60, 		4, 			'2020-02-10 05:39:01');
                        