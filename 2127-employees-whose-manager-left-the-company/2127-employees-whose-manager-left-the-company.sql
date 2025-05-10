# Write your MySQL query statement below

select e.employee_id
from Employees e
left join Employees f
on e.manager_id = f.employee_id
where e.salary < 30000 and e.manager_id is not null and f.employee_id is null
order by e.employee_id;