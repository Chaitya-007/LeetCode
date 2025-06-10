# Write your MySQL query statement below
select f.employee_id,f.name, count(*) as reports_count, round(avg(e.age)) as average_age
from Employees e
inner join Employees f
on e.reports_to = f.employee_id
group by f.employee_id
order by f.employee_id;