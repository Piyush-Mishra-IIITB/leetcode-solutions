# Write your MySQL query statement below

SELECT MAX(num) as num
from (
SELECT num
FROM MyNumbers
GROUP BY num
HAVING COUNT(num)<2
) as t

