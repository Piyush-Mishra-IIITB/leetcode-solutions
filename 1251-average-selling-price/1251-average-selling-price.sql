# Write your MySQL query statement below

with t as (select p.product_id,p.price,u.units
from Prices as p
join UnitsSold as u
on(p.product_id=u.product_id and p.start_date<=u.purchase_date and p.end_date>=u.purchase_date)),
 s as (select
 product_id,price*units as pr,
 sum(units) over(partition by product_id) as unit
 from t)

 select Distinct(product_id),coalesce(round(som/unit,2),0) as average_price
 from(select product_id,unit,
 sum(pr) over(partition by product_id) as som
 from s) as r
 
union all

select product_id,0 as average_price
from Prices
where product_id not in(
    select distinct(product_id)
    from UnitsSold
)