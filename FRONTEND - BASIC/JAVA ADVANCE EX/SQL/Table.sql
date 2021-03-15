/*============================== CREATE DATABASE =======================================*/
/*======================================================================================*/

DROP DATABASE IF EXISTS FinalAdvance;
CREATE DATABASE FinalAdvance;
USE FinalAdvance;

/*============================== CREATE TABLE =======================================*/
/*======================================================================================*/

-- create table 1: ACCOUNT
CREATE TABLE `Account`(
	account_id 		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	user_name 		VARCHAR(50) UNIQUE KEY NOT NULL ,
    email			VARCHAR(50) UNIQUE KEY NOT NULL,
    `password`		VARCHAR(15) NOT NULL, 
    full_name 		VARCHAR(50) NOT NULL
    
);
-- create table 2: Group
CREATE TABLE `Group`(
	group_id 		SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	group_name 		VARCHAR(50) UNIQUE KEY NOT NULL,
    `member` 		SMALLINT UNSIGNED DEFAULT '0',
    creator_id		SMALLINT UNSIGNED  DEFAULT '1',
    create_date 	DATETIME DEFAULT NOW(),
	FOREIGN KEY (creator_id) REFERENCES `Account` (account_id)
);