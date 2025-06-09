# Write your MySQL query statement below
select f.name
from Employee e
inner join Employee f
on e.managerId = f.id
group by e.managerId
having count(*) >= 5;