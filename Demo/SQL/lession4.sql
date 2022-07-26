SELECT * 
FROM `Account`
WHERE AccountID > 2
INTERSECT -- TRA THÊM GG VÌ ÍT DÙNG
SELECT * 
FROM `Account`
WHERE AccountID < 6;

-- Union chỉ lấy unique
-- Union all lấy tất cả  