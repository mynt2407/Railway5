/*============================== EXAM =======================================*/
/*======================================================================================*/

-- Để quản lý Thực tập của sinh viên, người ta xây dựng một cơ sở dữ liệu có tên là
-- ThucTap gồm các sơ đồ quan hệ sau (trường có dấu gạch chân là PrimaryKey):
--  GiangVien(magv, hoten, luong)
--  SinhVien(masv, hoten, namsinh, quequan)
--  DeTai(madt, tendt, kinhphi, NoiThucTap)
--  HuongDan(id, masv, madt, magv, ketqua)

DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE ThucTap;

/*============================== CREATE TABLE =======================================*/
/*======================================================================================*/

-- create table 1: GiangVien

CREATE TABLE GiangVien(
	Magv 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Hoten 	VARCHAR(50) NOT NULL,
    Luong	VARCHAR(50)
);


CREATE TABLE SinhVien(
	Masv 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Hoten 		VARCHAR(50) NOT NULL,
	Namsinh 	SMALLINT UNSIGNED,
    Quequan 	VARCHAR(50)
);

CREATE TABLE DeTai(
	MaDT 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	TenDT 	VARCHAR(50) NOT NULL,
    Kinhphi	VARCHAR(50) NOT NULL,
    Noithuctap VARCHAR(50) 
);


CREATE TABLE Huongdan(
	ID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Masv 	TINYINT UNSIGNED,
    MaDT	TINYINT UNSIGNED,
    Magv 	TINYINT UNSIGNED, 
    Ketqua	ENUM ('Đạt', 'Không đạt'),
    
FOREIGN KEY (Masv) REFERENCES SinhVien (Masv) ON DELETE CASCADE,
FOREIGN KEY (MaDT) REFERENCES DeTai (MaDT) ON DELETE CASCADE,
FOREIGN KEY (Magv) REFERENCES GiangVien (Magv) ON DELETE CASCADE
);

