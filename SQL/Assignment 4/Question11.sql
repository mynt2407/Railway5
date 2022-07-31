
SELECT  d.DepartmentID, d.DepartmentName, p.PositionID, p.PositionName, COUNT(a.AccountID) AS so_luong
FROM Department d
CROSS JOIN Position p
JOIN `Account` a ON a.DepartmentID = d.DepartmentID AND a.PositionID = p.PositionID
WHERE p.PositionName IN ('dev', 'Test', 'Scrum Master', 'PM')
GROUP BY d.DepartmentID, p.PositionID
ORDER BY d.DepartmentID, p.PositionID;

