# Write your MySQL query statement below
select w1.id from Weather w1 join Weather w2 on datediff(w1.recordDate, w2.recordDate) = 1 where w1.temperature > w2.temperature;

-- Components
-- DATEDIFF(date1, date2):

-- This function calculates the difference in days between date1 and date2.
-- The result is an integer representing the number of days.
-- The order of the arguments matters:
-- DATEDIFF(w1.recordDate, w2.recordDate) means it calculates w1.recordDate - w2.recordDate.
-- = 1:

-- This condition ensures the difference