# Write your MySQL query statement below


WITH T AS(
    select reports_to,avg(age) as average_age,count(*) as reports_count
    from Employees
    group by reports_to
)

select T.reports_to as employee_id ,e.name as name  ,T.reports_count as reports_count,ROUND(T.average_age ,0)as average_age
from T join Employees  as e 
on e.employee_id=T.reports_to
ORDER BY employee_id