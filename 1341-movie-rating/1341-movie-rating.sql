# Write your MySQL query statement below
with ActiveUsers as(
    select u.user_id from movierating mr, users u where u.user_id=mr.user_id group by u.user_id order by count(*) desc , u.name asc limit 1
),
MovieRatingHigh as(
    select m.movie_id from movierating mr, movies m where m.movie_id=mr.movie_id and created_at between '2020-02-01' and '2020-02-29' group by m.movie_id order by avg(mr.rating) desc , m.title asc limit 1
)

select name as results from users where user_id= (select user_id from ActiveUsers)
union all
select title as results from movies where movie_id =(select movie_id from MovieRatingHigh);