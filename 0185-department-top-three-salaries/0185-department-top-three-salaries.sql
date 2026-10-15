# Write your MySQL query statement below


with t as(
select e.name as name ,e.salary as salary ,d.id as dept_id ,d.name as dept
from Employee as e
join Department as d
on e.departmentId=d.id
),
s as (select name,dept,salary,
  dense_rank() over(partition by dept order by salary desc) as r
  from t)

 select dept as  Department ,name as Employee ,salary as Salary
 from s
 where r<4
