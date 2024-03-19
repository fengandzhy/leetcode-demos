/**
  DENSE_RANK()和RANK()都是SQL中的窗口函数，
  用于计算每行在其分区内的排名，但它们在处理相同值时的行为不同。这两个函数通常与OVER()子句一起使用，
  以指定排名的依据（如根据某列的值进行排序）  
  */
select
    score,(DENSE_RANK() over(order by score desc)) 'rank'
from Scores