# Write your MySQL query statement below
select req as id,count(*) as num
from 
(

(select requester_id as req
from RequestAccepted)

union all 

(select accepter_id as req
from RequestAccepted)
) as q
group by req
order by num desc
limit 0,1;
