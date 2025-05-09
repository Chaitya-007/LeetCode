# Write your MySQL query statement below

select 
person_name
from 
(
select *,sum(weight) over(order by turn) as cumm_wt
from Queue

) as q
where cumm_wt <= 1000
order by cumm_wt desc
limit 1;