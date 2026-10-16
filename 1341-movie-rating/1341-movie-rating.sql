
WITH user_counts AS (
    SELECT user_id, COUNT(*) AS c
    FROM MovieRating
    GROUP BY user_id
),
top_user AS (
    SELECT u.name AS results
    FROM Users u
    JOIN user_counts uc ON u.user_id = uc.user_id
    WHERE uc.c = (SELECT MAX(c) FROM user_counts)
    ORDER BY u.name
    LIMIT 1
),
movie_avg AS (
    SELECT movie_id, AVG(rating) AS r
    FROM MovieRating
    WHERE DATE_FORMAT(created_at, '%Y-%m') = '2020-02'
    GROUP BY movie_id
),
top_movie AS (
    SELECT m.title AS results
    FROM Movies m
    JOIN movie_avg ma ON m.movie_id = ma.movie_id
    WHERE ma.r = (SELECT MAX(r) FROM movie_avg)
    ORDER BY m.title
    LIMIT 1
)
SELECT results FROM top_user
UNION ALL
SELECT results FROM top_movie;
