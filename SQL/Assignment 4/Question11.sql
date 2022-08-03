-- Câu 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
CREATE VIEW bang_mau AS
SELECT d.DepartmentID, p.PositionID,  d.DepartmentName, COUNT(a.AccountID) AS so_luong_nv, GROUP_CONCAT(p.PositionName) AS vi_tri
FROM Department d
CROSS JOIN Position p
JOIN `Account` a ON d.DepartmentID = a.DepartmentID AND p.PositionID = a.PositionID
WHERE p.PositionName IN ('Dev', 'Test', 'Scrum Master', 'PM')
GROUP BY d.DepartmentID
ORDER BY d.DepartmentID

