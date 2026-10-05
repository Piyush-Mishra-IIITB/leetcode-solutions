# Write your MySQL query statement below

SELECT id
FROM Weather w1
WHERE temperature > (
    SELECT temperature
    FROM Weather w2
    WHERE w2.recordDate = w1.recordDate - INTERVAL 1 DAY
);