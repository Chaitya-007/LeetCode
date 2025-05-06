# Write your MySQL query statement below

select 
Left(t.trans_date,7) as month
,t.country
,count(*) as trans_count
,sum(if(t.state = 'approved', 1, 0)) as approved_count
,sum(t.amount) as trans_total_amount
,sum(case when t.state = 'approved' then t.amount else 0 end) as approved_total_amount
from Transactions t
group by 
month,t.country;
