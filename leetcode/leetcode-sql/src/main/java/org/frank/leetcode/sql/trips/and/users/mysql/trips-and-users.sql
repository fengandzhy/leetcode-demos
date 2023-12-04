SELECT
    request_at AS DAY,
	ROUND(sum(IF(t.status = 'cancelled_by_driver' OR t.status = 'cancelled_by_client', 1, 0))/ count(*), 2) AS 'Cancellation Rate'
FROM
    Trips t
    LEFT JOIN Users u1 ON
    t.client_id = u1.users_id
    LEFT JOIN Users u2 ON
    t.driver_id = u2.users_id
WHERE
    u1.banned = 'NO'
  AND u2.banned = 'NO'
  AND request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY
    request_at;

-----------------------------------------------

SELECT
    a.request_at AS DAY,
	ROUND( sum( CASE WHEN STATUS IN ( 'cancelled_by_driver', 'cancelled_by_client' ) THEN 1 ELSE 0 END ) / count( * ), 2 ) AS "Cancellation Rate"
FROM
    Trips a
    LEFT JOIN Users b ON a.client_id = b.users_id
    LEFT JOIN Users c ON a.driver_id = c.users_id
WHERE
    a.request_at >= "2013-10-01"
  AND a.request_at <= "2013-10-03"
  AND b.banned = 'No'
  AND c.banned = 'No'
GROUP BY
    a.request_at

---------------------------------------------------------

with unbanned_users as (
    select users_id from Users WHERE banned="Yes"
    )

SELECT
    request_at AS Day,
    ROUND(COUNT(CASE WHEN (status IN ('cancelled_by_driver','cancelled_by_client'))
            THEN id else null end)/COUNT(id),2) as "Cancellation Rate"

FROM
    Trips
WHERE
    client_id NOT IN (SELECT * FROM unbanned_users)
  and driver_id NOT IN (SELECT * FROM unbanned_users)
  and (request_at > '2013-09-29' AND request_at < '2013-10-04')

GROUP BY 1

------------------------------------------------------------------

SELECT T.request_at AS `Day`,
       ROUND(
                   SUM(
                           IF(T.STATUS = 'completed',0,1)
                       )
                   /
                   COUNT(T.STATUS),
                   2
           ) AS `Cancellation Rate`
FROM trips AS T
WHERE
        T.Client_Id NOT IN (
        SELECT users_id
        FROM users
        WHERE banned = 'Yes'
    )
  AND
        T.Driver_Id NOT IN (
        SELECT users_id
        FROM users
        WHERE banned = 'Yes'
    )
  AND T.request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY T.request_at



