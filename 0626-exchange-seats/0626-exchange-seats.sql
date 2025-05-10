# Write your MySQL query statement below



select *
from
(

select s.id, 
        case 
        when r.id is not null
        then r.student
        else s.student
        end  as student
from Seat s
left join Seat r
on s.id%2 != 0 and s.id = r.id - 1
where s.id%2 != 0

union

select 
    case 
    when r.id is not null
    then r.id
    else null
    end as id,
    case 
    when r.id is not null
    then s.student
    else null
    end as student
from Seat s
left join Seat r
on s.id%2 != 0 and s.id = r.id - 1
where s.id%2 != 0
) as q
where id is not null
order by id;

