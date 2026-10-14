# Write your MySQL query statement below



with t as(
    select person_id,person_name,
    sum(weight) over( order by turn ) as running_wt
    from Queue
)
select person_name
from t
where running_wt<=1000
order by running_wt desc
limit 1