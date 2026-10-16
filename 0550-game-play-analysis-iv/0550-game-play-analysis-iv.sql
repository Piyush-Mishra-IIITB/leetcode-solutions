
WITH t AS (
    SELECT player_id,
           event_date,
           ROW_NUMBER() OVER (
               PARTITION BY player_id
               ORDER BY event_date
           ) AS rk,
           LEAD(event_date) OVER (
               PARTITION BY player_id
               ORDER BY event_date
           ) AS next_date
    FROM Activity
),
first_login AS (
    SELECT player_id, next_date
    FROM t
    WHERE rk = 1
)
SELECT ROUND(
    SUM(
        CASE
            WHEN DATEDIFF(next_date, (
                SELECT MIN(event_date)
                FROM Activity a
                WHERE a.player_id = f.player_id
            )) = 1 THEN 1
            ELSE 0
        END
    ) / COUNT(*),
    2
) AS fraction
FROM first_login f;
