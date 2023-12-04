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