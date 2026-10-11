# Write your MySQL query statement below

WITH T AS(
    SELECT DISTINCT(COUNT(user_id)) AS total
    FROM Users
),
P AS(
    SELECT contest_id AS c_id,COUNT(user_id) AS count
    FROM Register
    GROUP BY(contest_id)
)

SELECT P.c_id AS contest_id,ROUND((P.count/T.total)*100,2) AS percentage
FROM P CROSS JOIN T
ORDER BY percentage DESC,contest_id ASC