# Write your MySQL query statement below

select q.query_name
,round( (sum(q.rating/q.position))/count(*), 2) as quality
,round( avg ( if(q.rating < 3,1,0) ) * 100.0 , 2) as poor_query_percentage
from Queries q
group by q.query_name;