-- Exercise 1: Subquery
-- Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory là 'Saddles'

USE `adventureworks`;
DROP VIEW IF EXISTS DANH_MUC_TEN;
CREATE VIEW DANH_MUC_TEN AS
SELECT		P.`Name`
FROM 		ProductSubcategory PST
JOIN 		Product P ON PST.ProductSubcategoryID = P.ProductSubcategoryID
WHERE 		P.ProductSubcategoryID IN (SELECT PST.ProductSubcategoryID
									FROM 	adventureworks.productsubcategory PST
									WHERE 	PST.`Name` = 'Saddles')
;
-- Question 2: Thay đổi câu Query 1 để lấy được kết quả sau.

SELECT		P.`Name`
FROM 		ProductSubcategory PST
JOIN 		Product P ON PST.ProductSubcategoryID = P.ProductSubcategoryID
WHERE 		PST.ProductSubcategoryID IN (SELECT P.ProductSubcategoryID
									FROM 	adventureworks.Product P
									WHERE 	P.`Name` LIKE '%Bo%')
ORDER BY 	P.`Name` DESC;

-- Code lai
SELECT		P.`Name`
FROM 		ProductSubcategory PST
JOIN 		Product P ON PST.ProductSubcategoryID = P.ProductSubcategoryID
WHERE 		P.`Name` LIKE '%Bo%';

-- Question 3: Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và 
-- Touring Bike (nghĩa là ProductSubcategoryID = 3)

SELECT 		P.`Name`
FROM 		ProductSubcategory PST
JOIN 		Product P ON PST.ProductSubcategoryID = P.ProductSubcategoryID
WHERE 		P.ProductSubcategoryID  = 3 AND P.ListPrice =	(SELECT 	MIN(P.ListPrice) 
															FROM 		ProductSubcategory PST
															JOIN 		Product P ON PST.ProductSubcategoryID = P.ProductSubcategoryID
                                                            WHERE 		P.ProductSubcategoryID  = 3					
                                                            )
;
-- LÀM THÊM CTE

-- Exercise 2: JOIN nhiều bảng
-- Question 1: Viết query lấy danh sách tên country và province được lưu trong AdventureWorks2008 sample database. 

USE adventureworks;

WITH COUNTRY_CITY(COUNTRY_NAME,CITY_NAME) AS(
SELECT 	CTR.`Name` AS COUNTRY_NAME, STP.`Name` AS CITY_NAME
FROM 	countryregion CTR
JOIN 	stateprovince STP ON CTR.CountryRegionCode = STP.CountryRegionCode
)

SELECT *
FROM 	COUNTRY_CITY;

-- Question 2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada
-- Chú ý: sủ dụng sort order và column headings
WITH COUNTRY_CITY(COUNTRY_NAME,CITY_NAME) AS(
SELECT 	CTR.`Name` AS COUNTRY_NAME, STP.`Name` AS CITY_NAME
FROM 	countryregion CTR
JOIN 	stateprovince STP ON CTR.CountryRegionCode = STP.CountryRegionCode
WHERE 	CTR.`Name` = 'Canada' OR CTR.`Name` = 'Germany'
)

SELECT *
FROM 	COUNTRY_CITY;

-- Question 3: SalesOrderID, OrderDate and SalesPersonID. Từ bảng SalesPerson, chúng ta lấy cột
-- BusinessEntityID (là định danh của người sales), Bonus and the SalesYTD (là đã sale được bao nhiêu người trong năm nay)

WITH INFORMATION AS (
SELECT 	SOH.SalesOrderID, SOH.OrderDate, SP.SalesPersonID, SP.Bonus, SP.SalesYTD
FROM 	SalesPerson SP 
JOIN 	salesorderheader SOH ON SP.SalesPersonID = SOH.SalesPersonID)
SELECT *
FROM INFORMATION ;

-- Question 4: Sử dụng câu query, thêm cột JobTitle and xóa cột SalesPersonID và BusinessEntityID vendoraddressunitmeasure
WITH INFORMATION AS (
SELECT 	SOH.SalesOrderID, SOH.OrderDate, SP.SalesPersonID, SP.Bonus, SP.SalesYTD
FROM 	SalesPerson SP 
JOIN 	salesorderheader SOH ON SP.SalesPersonID = SOH.SalesPersonID)
SELECT *
FROM 		INFORMATION; 
ALTER TABLE INFORMATION
ADD 		JobTitle VARCHAR(50) UNIQUE KEY NOT NULL;