SELECT
    employee.NAME,
    bonus.bonus
FROM
    Employee employee
        LEFT JOIN Bonus bonus ON employee.empId = bonus.empId
WHERE
        bonus.bonus < 1000
   OR bonus.bonus IS NULL;