DELETE c
FROM countries c
LEFT JOIN movies m ON c.id = m.country_id
WHERE m.id IS NULL;