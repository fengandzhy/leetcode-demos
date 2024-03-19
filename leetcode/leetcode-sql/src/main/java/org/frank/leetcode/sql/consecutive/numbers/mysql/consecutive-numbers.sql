
/*
LEAD()函数是SQL中的一个窗口函数，用于从当前行开始向前查看一定数量的行中的数据。
简单来说，LEAD()可以让你访问当前行之后的行中的数据，而无需执行自连接或复杂的子查询。
这在处理涉及到行与行之间比较或需要基于当前行数据的前后关系进行计算的查询时特别有用。
*/
SELECT DISTINCT Num AS ConsecutiveNums
FROM (
         SELECT Num,
                LEAD(Num, 1) OVER (ORDER BY Id) AS NextNum1,
                 LEAD(Num, 2) OVER (ORDER BY Id) AS NextNum2
         FROM Logs
     ) AS SubQuery
WHERE Num = NextNum1 AND Num = NextNum2;



SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
        l1.Id = l2.Id - 1
  AND l2.Id = l3.Id - 1
  AND l1.Num = l2.Num
  AND l2.Num = l3.Num
;
