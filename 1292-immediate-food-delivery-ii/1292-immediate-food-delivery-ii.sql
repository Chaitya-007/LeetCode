-- # Write your MySQL query statement below
select round( avg( if(d.order_date = d.customer_pref_delivery_date,1,0) )*100.0, 2) as immediate_percentage
from Delivery d
where (d.customer_id,d.order_date) in (
    select customer_id,min(order_date)
    from delivery
    group by customer_id
);
