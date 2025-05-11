# Write your MySQL query statement below

with all_id as 
(
    select r.requester_id  as id from RequestAccepted r

    union all

    select q.accepter_id as id from RequestAccepted q
)

select id,count(*) as num
from all_id
group by id
order by count(*) desc
limit 1;
