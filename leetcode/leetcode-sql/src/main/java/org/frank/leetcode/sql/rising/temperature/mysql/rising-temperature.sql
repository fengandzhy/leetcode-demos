
/**
  * 把自己看成一个表, 自己跟自己比. 查询今天的气温比昨天高的id, 首先查找id 在一个表里 w, 
  * 然后要跟上一个表里的东西比, 具体比天数比它靠后一天, 温度比它高
  */
SELECT
    w.id
FROM
    Weather w,
    Weather ww
WHERE
        subdate( w.recordDate, 1 ) = ww.recordDate
  AND w.Temperature > ww.Temperature