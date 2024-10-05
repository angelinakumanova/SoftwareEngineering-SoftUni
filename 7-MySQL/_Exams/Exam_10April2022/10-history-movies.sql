DELIMITER $$
CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50)) 
RETURNS INT
READS SQL DATA
BEGIN
	RETURN (SELECT COUNT(*)
	FROM movies_actors ma
	JOIN actors a ON ma.actor_id = a.id
	JOIN movies m ON ma.movie_id = m.id
	JOIN genres_movies gm ON m.id = gm.movie_id
	JOIN genres g ON gm.genre_id = g.id
	WHERE CONCAT_WS(' ', a.first_name, a.last_name) = full_name AND g.name = 'history');
END$$



