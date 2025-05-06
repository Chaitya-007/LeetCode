# Write your MySQL query statement below
-- select ( sum(if( (d.order_date limit 1) = (d.customer_pref_delivery_date limit 1),1,0))*100 )/(select count(distinct customer_id) from Delivery) as immediate_percentage
select round( avg( if(d.order_date = d.customer_pref_delivery_date,1,0) )*100.0, 2) as immediate_percentage
from Delivery d
where (d.customer_id,d.order_date) in (
    select customer_id,min(order_date)
    from delivery
    group by customer_id
);

