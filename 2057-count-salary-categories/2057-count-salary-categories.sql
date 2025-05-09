# Write your MySQL query statement below

select category, accounts_count
from 
(

select 'Low Salary' as category,count(*) as accounts_count
from Accounts
where income < 20000

union 


select 'Average Salary' as category,count(*) as accounts_count
from Accounts
where income between 20000 and 50000

union

select 'High Salary' as category,count(*) as accounts_count
from Accounts
where income > 50000
) as q
order by 
case  
    when category = 'High Salary' then 1
    when category = 'Low Salary' then 2
    when category = 'Average Salary' then 3
    else 4
end;


