# Write your MySQL query statement below
-- select *
select p.product_id, ifnull(round(sum(p.price*u.units)/sum(u.units),2),0) as average_price
from Prices p
left join UnitsSold u
on datediff(u.purchase_date,p.start_date) >= 0 
and datediff(p.end_date,u.purchase_date) >= 0
and p.product_id = u.product_id
group by p.product_id;