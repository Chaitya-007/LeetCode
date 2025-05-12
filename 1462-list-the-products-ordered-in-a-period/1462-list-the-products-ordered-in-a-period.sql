# Write your MySQL query statement below


select p.product_name, sum(unit) as unit
from Orders o
left join Products p
on o.product_id = p.product_id
where substr(o.order_date,1,7) = '2020-02' 
group by o.product_id
having sum(unit) >=100;

