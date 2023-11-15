# Write your MySQL query statement below

select c.name as Customers from Customers c
where not exists (select * from Orders o where o.customerId = c.id)