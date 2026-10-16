# Write your MySQL query statement below
with t as(
   select product_id,new_price,change_date,
   row_number() over(partition by product_id order by change_date desc) as rk
   from Products
   where datediff('2019-08-16',change_date)>=0
)
select distinct(product_id),price
from (
select product_id,new_price as price
from t
where rk=1

union all
 
 select product_id,10 as price
 from Products
 where product_id not in(
    select product_id 
    from t
 )
) as l
order by price