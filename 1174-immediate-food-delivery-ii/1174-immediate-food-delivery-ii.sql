
WITH t AS (
    SELECT
        delivery_id,
        customer_id,
        order_date,
        customer_pref_delivery_date,
        ROW_NUMBER() OVER (
            PARTITION BY customer_id
            ORDER BY order_date, delivery_id
        ) AS rk
    FROM Delivery
),
p AS (
    SELECT *
    FROM t
    WHERE rk = 1
),
q AS (
    SELECT
        COUNT(delivery_id) AS total,
        SUM(
            CASE
                WHEN order_date = customer_pref_delivery_date
                THEN 1
                ELSE 0
            END
        ) AS good
    FROM p
)
SELECT ROUND(good * 100.0 / total, 2) AS immediate_percentage
FROM q;
