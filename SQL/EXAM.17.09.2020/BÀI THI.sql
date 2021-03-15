-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT		 *
FROM 		SinhVien S 
LEFT JOIN 	Huongdan HD ON S.Masv = HD.Masv
WHERE 		HD.Masv IS NULL;

-- b) Lấy ra số sinh viên nghiên cứu đề tài ‘Nghiên cứu virus PRRS’

SELECT 		*
FROM  		SinhVien S
JOIN	 	Huongdan HD ON S.Masv = HD.Masv
JOIN 		DeTai DT ON DT.MaDT = HD.MaDT
WHERE 		DT.TenDT LIKE 'Nghiên cứu virus PRRS'
GROUP BY 	HD.Masv
HAVING 		COUNT(HD.MaDT);

-- Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
-- mã số, họ tên và tên đề tài
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")

DROP VIEW IF EXISTS SinhVienInfo;
CREATE VIEW SinhVienInfo AS 

SELECT		 *
FROM 		SinhVien S 
LEFT JOIN 	Huongdan HD ON S.Masv = HD.Masv
LEFT JOIN 	DeTai DT ON DT.MaDT = HD.MaDT;

SELECT *,
CASE 
	WHEN 	ID IS NULL THEN 'Chưa có'
	ELSE 	'Đã có'
END	AS 	bai_thi
FROM 	SinhVienInfo;


-- Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900
-- thì hiện ra thông báo "năm sinh phải > 1900"

DROP TRIGGER IF EXISTS nam_sinh;
DELIMITER $$
CREATE TRIGGER nam_sinh
BEFORE INSERT ON SinhVien
FOR EACH ROW
BEGIN

DECLARE input_namsinh SMALLINT;
SELECT NEW.Namsinh INTO input_namsinh;

IF input_namsinh <= 1900 THEN
SIGNAL SQLSTATE '12345'
SET MESSAGE_TEXT = ' Năm sinh phải > 1900';
END IF;
END $$
DELIMITER ;

INSERT INTO  SinhVien 	(	Hoten,				Namsinh,		Quequan)
VALUES					(N'Nguyễn Văn A', 		'1880',			N'Hà Nội');

-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
-- tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
DELETE
FROM SinhVien
WHERE Masv = 2;

SELECT *
FROM SinhVien;

SELECT *
FROM Huongdan;




