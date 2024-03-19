select MAX(salary) as SecondHighestSalary from Employee where salary < (select MAX(salary) from Employee );

/**
  LIMIT M OFFSET N 
  跳过N条记录,返回M记录
  */
SELECT (
   SELECT DISTINCT Salary
   FROM Employee
   ORDER BY Salary DESC
   LIMIT 1 OFFSET 1 
) AS SecondHighestSalary;