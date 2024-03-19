select MAX(salary) as SecondHighestSalary from Employee where salary < (select MAX(salary) from Employee );

SELECT (
   SELECT DISTINCT Salary
   FROM Employee
   ORDER BY Salary DESC
   LIMIT 1 OFFSET 1
) AS SecondHighestSalary;