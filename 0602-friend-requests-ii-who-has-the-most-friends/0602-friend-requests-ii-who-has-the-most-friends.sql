# Write your MySQL query statement below
with tab as 
(

(select requester_id as req
from RequestAccepted)

union all 

(select accepter_id as req
from RequestAccepted)

)


select req as id,count(*) as num
from tab
group by req
order by num desc
limit 0,1;
