
/**
  主查询：

选择Employee表（别名e1）和Department表进行内连接，目的是获取每个员工的部门名称、员工姓名和薪水。
子查询：

对于主查询中的每个员工记录（e1），子查询计算在同一个部门中，有多少不同的薪水值大于e1的薪水。这通过在Employee表上进行自连接（别名e2）并设置条件e2.Salary > e1.Salary AND e1.DepartmentId = e2.DepartmentId来实现。
使用COUNT(DISTINCT e2.Salary)来统计满足条件的不同薪水的数量，确保即使多个员工有相同的薪水也只被计数一次。
WHERE子句：

主查询中的WHERE子句通过3 > (...)来确保只选择那些在其部门内薪水排名前三的员工。具体来说，如果子查询计算的大于e1薪水的不同薪水数量小于3，那么e1就是其部门内薪水排名前三的员工之一。
  */

-- 从 e1 和 d 中 选取 Department 和 Employee 然后条件是 拿 e2表跟 e1 表比 e2.Salary > e1.Salary
SELECT
    d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
FROM
    Employee e1
        JOIN
    Department d ON e1.DepartmentId = d.Id
WHERE
        3 > (SELECT
                 COUNT(DISTINCT e2.Salary)
             FROM
                 Employee e2
             WHERE
                     e2.Salary > e1.Salary
               AND e1.DepartmentId = e2.DepartmentId
    );