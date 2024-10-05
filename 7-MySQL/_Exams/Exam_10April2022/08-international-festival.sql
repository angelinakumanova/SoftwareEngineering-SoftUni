SELECT c.name, COUNT(*) AS movies_count
FROM countries c
JOIN movies m ON c.id = m.country_id
GROUP BY c.name
HAVING movies_count >= 7
ORDER BY name DESC;