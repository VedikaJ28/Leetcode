# Write your MySQL query statement below
with cte as(
    select sum(weight) over(order by turn) as accWeight , person_name from queue
)
select person_name from cte where accWeight<=1000 order by accWeight desc limit 1;