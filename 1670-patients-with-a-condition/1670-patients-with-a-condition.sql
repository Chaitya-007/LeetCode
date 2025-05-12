# Write your MySQL query statement below
select * 
from Patients
where locate(" DIAB1",conditions) <> 0 or locate("DIAB1",conditions) = 1;