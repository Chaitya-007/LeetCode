# Write your MySQL query statement below

select f.name
from employee e
inner join employee f
on e.managerId = f.id
group by f.id
having count(*) >= 5;