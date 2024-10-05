SELECT mai.id, m.title, mai.runtime, mai.budget, mai.release_date
FROM movies m
JOIN movies_additional_info mai ON m.movie_info_id = mai.id
WHERE YEAR(mai.release_date) BETWEEN 1996 AND 1999
ORDER BY mai.runtime, mai.id
LIMIT 20;
