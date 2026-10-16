# Write your MySQL query statement below

with t as(
select id,email,
 row_number() over(partition by email order by id) as rk
 from Person),
 p as(select id
 from t
 where rk=1)

 delete 
 from Person
 where id not in(
    select id
    from p
 )