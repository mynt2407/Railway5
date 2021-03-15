/*==================== EXTRA ====================*/
-- Exercise 1: 
-- Give following table:
-- Department (Department_Number, Department_Name)
-- Employee_Table (Employee_Number, Employee_Name, Department_Number)
-- Employee_Skill_Table (Employee_Number, Skill_Code, Date Registered)

/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/

-- Create database 
DROP DATABASE IF EXISTS Manager_Employee;
CREATE DATABASE Manager_Employee;
USE Manager_Employee;

/*============================== CREATE TABLE =======================================*/
/*======================================================================================*/
-- Create table: Department 
CREATE TABLE Department (
Department_Number 	TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Department_Name		VARCHAR(50) UNIQUE KEY CHECK(LENGTH(Department_Name) < 20)
);

-- Create table :Employee_Table (Employee_Number, Employee_Name, Department_Number)
CREATE TABLE Employee_Table (
Employee_Number		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Employee_Name 		VARCHAR(50) NOT NULL,
Department_Number	TINYINT UNSIGNED NOT NULL,
FOREIGN KEY (Department_Number) REFERENCES Department (Department_Number)
);

-- Create Employee_Skill_Table (Employee_Number, Skill_Code, Date_Registered)
CREATE TABLE Employee_Skill_Table (
Employee_Number TINYINT UNSIGNED NOT NULL,
Skill_Code		VARCHAR(30) UNIQUE KEY NOT NULL,
Date_Registered DATE,
FOREIGN KEY (Employee_Number) REFERENCES Employee_Table (Employee_Number)
);
