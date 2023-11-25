-- 查询第三高工资的信息
SELECT * FROM (SELECT * FROM employee1 e1 ORDER BY e1.salary desc LIMIT 3) aa
WHERE NOT EXISTS (SELECT * FROM (SELECT * FROM employee1 e2 ORDER BY e2.salary desc LIMIT 2) bb WHERE bb.id = aa.id)

-- 查询第三高工资的信息
SELECT * FROM employee1 e1 ORDER BY e1.salary desc LIMIT 1 OFFSET 2;

SELECT d.name, e.name,e.salary
FROM employee1 e
         INNER JOIN department1 d on e.departmentid = d.id
WHERE 3 >
      (SELECT COUNT(DISTINCT e1.salary) FROM employee1 e1
       WHERE e1.salary > e.salary
         and e.departmentId = e1.departmentId)