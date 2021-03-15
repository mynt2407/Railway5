DROP DATABASE IF EXISTS Fresher_Training_Management;
CREATE DATABASE Fresher_Training_Management;
USE	Fresher_Training_Management;

-- Exercise 1:Design a table 

-- Question 1: Create the tables

CREATE TABLE `Trainee table` (
TraineeID 			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Full_Name			VARCHAR(50) NOT NULL,
Birth_Date 			DATE, -- CHECK (BirthDate BETWEEN '1900-01-01' AND '2011-12-08'),
Gender 				ENUM ('Male', 'female', 'unknown') NOT NULL,
ET_IQ 				TINYINT UNSIGNED CHECK (ET_IQ > 100),
ET_Gmath 			TINYINT UNSIGNED CHECK (ET_Gmath > 0 AND ET_Gmath < 20),
ET_English 			TINYINT UNSIGNED CHECK (ET_English > 0 AND ET_English < 50),
Training_Class 		VARCHAR(50) NOT NULL,
Evaluation_Notes 	NVARCHAR(500)
);

-- question 2: Thêm column VTI_account
ALTER TABLE `Trainee table`
ADD COLUMN VTI_account TINYINT UNSIGNED AFTER  Gender;

-- Exercise 2: Data Types

CREATE TABLE `Data Types`(
ID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`Name` 			VARCHAR(50) NOT NULL,
`Code` 			CHAR(5), 
ModifiedDate 	DATETIME DEFAULT now()
);

-- Exercise 3: Data Types (2)

CREATE TABLE `Data Types (2)` (
ID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
`Name` 			VARCHAR(50) NOT NULL,
BirthDate 		DATE CHECK (BirthDate BETWEEN '1990-01-01' AND '2011-02-08'),
Gender			BIT,
IsDeletedFlag  	ENUM ('0', '1')
);


