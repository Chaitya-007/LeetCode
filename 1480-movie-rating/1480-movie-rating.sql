# Write your MySQL query statement below


-- Enclosing each query in parentheses tells MySQL to treat them 
-- as separate subqueries before combining the results with UNION. This corrects the syntax error.

(select u.name as results
from MovieRating mr 
left join Users u
on mr.user_id = u.user_id
group by mr.user_id
order by 
    count(*) desc,
    u.name asc
limit 1)

union all

(select m.title as results
from MovieRating mr
inner join Movies m
on mr.movie_id = m.movie_id
where left(created_at,7) = '2020-02'
group by mr.movie_id
order by 
    avg(rating) desc,
    m.title asc
    limit 1);
