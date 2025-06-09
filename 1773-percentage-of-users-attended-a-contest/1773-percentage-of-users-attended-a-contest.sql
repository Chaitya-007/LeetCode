# Write your MySQL query statement below
select r.contest_id,
round( (count(distinct r.user_id) * 100.0)/(select count(distinct user_id) from Users), 2 ) as percentage
from Users u
inner join Register r
on r.user_id = u.user_id
group by r.contest_id
order by percentage desc, contest_id asc;
