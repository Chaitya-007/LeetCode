# Write your MySQL query statement below

(select u.name as results
from MovieRating mr
inner join Users u
on u.user_id = mr.user_id
group by u.name
order by count(*) desc,u.name asc
limit 0,1)


union all


(select m.title as results
from MovieRating mr
inner join Movies m
on mr.movie_id = m.movie_id
where left(mr.created_at,7) = '2020-02'
group by m.title
order by avg(rating) desc, m.title asc
limit 0,1);

