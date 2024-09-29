SELECT mc.country_code, COUNT(mountain_range) AS mountain_range
FROM mountains m
	JOIN mountains_countries mc ON m.id = mc.mountain_id
	WHERE country_code IN ('BG', 'US', 'RU')
GROUP BY mc.country_code
ORDER BY mountain_range DESC;
