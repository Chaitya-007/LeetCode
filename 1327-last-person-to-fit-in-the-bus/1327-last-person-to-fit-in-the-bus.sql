# Write your MySQL query statement below
select person_name
from 
(

select * , sum(weight) over(order by turn) as agg_wt
from Queue
) as q
where agg_wt <= 1000
order by agg_wt desc
limit 0,1;
