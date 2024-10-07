INSERT INTO games (name, rating, budget, team_id)
SELECT
	REVERSE(LOWER(SUBSTRING(name, 2, CHAR_LENGTH(name)))) AS name,
    id AS rating,
    leader_id * 1000 AS budget,
    id AS team_id
FROM teams
WHERE id BETWEEN 1 AND 9;