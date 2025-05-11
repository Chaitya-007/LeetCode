# Write your MySQL query statement below


select c.visited_on,
(select sum(d.amount) 
from Customer d
where d.visited_on between date_sub(c.visited_on,interval 6 day) and c.visited_on
) as amount,
round((
    select sum(e.amount)/7
    from Customer e 
    where e.visited_on between date_sub(c.visited_on,interval 6 day) and c.visited_on
),2) as average_amount
from Customer c
where visited_on >= 
(
    select date_add(min(visited_on),interval 6 day) from Customer
)
group by c.visited_on
order by c.visited_on;