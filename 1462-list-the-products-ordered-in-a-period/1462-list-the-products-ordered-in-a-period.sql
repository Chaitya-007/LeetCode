# Write your MySQL query statement below

select distinct product_name,amt as unit
from
(

select p.product_name,sum(unit) over(partition by o.product_id ) as amt
from Orders o
left join Products p
on o.product_id = p.product_id
where substr(o.order_date,1,7) = '2020-02' 
) as q
where amt >= 100;
