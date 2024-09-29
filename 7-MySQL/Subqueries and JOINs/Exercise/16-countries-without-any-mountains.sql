SELECT COUNT(*)
FROM countries c
LEFT JOIN mountains_countries mc ON mc.country_code = c.country_code
WHERE mc.mountain_id IS NULL;

