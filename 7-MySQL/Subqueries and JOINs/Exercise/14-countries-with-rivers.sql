SELECT c.country_name, r.river_name
FROM countries c
	LEFT JOIN countries_rivers cr ON c.country_code = cr.country_code
	LEFT JOIN rivers r ON cr.river_id = r.id
	JOIN continents ct ON ct.continent_code = c.continent_code
WHERE ct.continent_name = 'Africa'
ORDER BY c.country_name
LIMIT 5;
