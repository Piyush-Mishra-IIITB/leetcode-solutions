# Write your MySQL query statement below


with t as(select num,
   lead(num) over(order by id) as first_lead,
   lead(num,2) over (order by id) as second_lead
from Logs)
select Distinct(t.num) as ConsecutiveNums
from t
where t.num=t.first_lead AND t.first_lead=t.second_lead