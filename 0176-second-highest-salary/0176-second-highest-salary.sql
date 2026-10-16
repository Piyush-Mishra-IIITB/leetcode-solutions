# Write your MySQL query statement below

select max(salary) as SecondHighestSalary 
from(
select salary,
dense_rank() over(order by salary desc) as rk
from Employee
) as p
where rk=2
