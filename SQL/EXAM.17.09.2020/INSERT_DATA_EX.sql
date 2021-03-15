/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
INSERT INTO GiangVien 	(Magv,	Hoten,					Luong)  
VALUES
						(1,		N'Nguyễn Ngọc Duy',		'10.000.000'),
						(2,		N'Nguyễn Thị Mỵ',		'15.000.000'),
						(3,		N'Nguyễn Thế Hưng',		'8.000.000');

INSERT INTO  SinhVien 	(	Hoten,			Namsinh,		Quequan)
VALUES					(N'Nguyễn Thế Đức', '1995',			N'Hà Nội'),
						(N'Vũ Hoàng HiệP', 	'1989',			N'Hà Nam'),
                        (N'Tống Thị Nhung', '2000',			N'Nam Định');
                        
INSERT INTO	DeTai		(TenDT,						Kinhphi,		Noithuctap)
VALUES 					(N'Nghiên cứu virus PRRS',  '3.000.000',	N'Hà Nội'),
						(N'Trồng nấm', 				'3.500.000',	N'Cao Bằng'),
                        (N'Nghiên cứu Vi khuẩn', 	'4.000.000',	N'Huế');
                        
INSERT INTO Huongdan	(Masv,		MaDT,		Magv,	Ketqua)
VALUES					(3,			2,			2,		'Đạt'),
						(2,			1,			2,		'Không đạt'),
                        (2,			2,			1,		'Đạt');