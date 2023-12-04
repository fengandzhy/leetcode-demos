-- 这是一个所有 trips 和 users 的笛卡尔乘积, 指将一个表中的每一行与另一个表中的每一行进行组合，从而生成一个新的表
SELECT
    *
FROM
    Trips AS T
        JOIN Users AS U;


/**
* ON后面这是笛卡尔集合的条件 T.client_id = U.users_id OR T.driver_id = U.users_id 这就有可能一条记录有两个满足条件的
* 例如 在Trips 中有id = 1 这条记录, 在这里就可以有两个记录
*/
SELECT
    *
FROM
    Trips AS T
        JOIN Users AS U ON ( T.client_id = U.users_id OR T.driver_id = U.users_id )
        AND U.banned = 'No'