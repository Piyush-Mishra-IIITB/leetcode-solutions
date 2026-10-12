# Write your MySQL query statement below



WITH T AS (
    SELECT COUNT(DISTINCT product_key) AS total
    FROM Product
),
Q AS (
    SELECT customer_id, COUNT(DISTINCT product_key) AS no
    FROM Customer
    GROUP BY customer_id
)
SELECT Q.customer_id
FROM Q
CROSS JOIN T
WHERE Q.no = T.total;
     