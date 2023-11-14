select d.name as Department,
       e.name as Employee,
       e.salary as Salary
from Employee e
         inner join Department d on e.departmentId = d.id
where e.salary in
      (select max(salary) from Employee e1
       where e.departmentId = e1.departmentId group by e1.departmentId)#这里的group by 必须放在where 之后

##以下是一个连表用group by 的例子
select d.name as Department,
       e.name as Employee,
       e.salary as Salary
from Employee e
         inner join Department d on e.departmentId = d.id
where e.salary in
      (select max(salary) from Employee e1 inner join Department d1 on e1.departmentId = d1.id
       where e.departmentId = e1.departmentId group by d1.id)