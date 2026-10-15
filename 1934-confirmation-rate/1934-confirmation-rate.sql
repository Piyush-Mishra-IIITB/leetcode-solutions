
WITH t AS (
    SELECT
        user_id,
        COUNT(*) AS total,
        SUM(CASE WHEN action = 'confirmed' THEN 1 ELSE 0 END) AS confrm
    FROM Confirmations
    GROUP BY user_id
)
SELECT
    s.user_id,
    ROUND(COALESCE(t.confrm / t.total, 0), 2) AS confirmation_rate
FROM Signups AS s
LEFT JOIN t
    ON s.user_id = t.user_id;
