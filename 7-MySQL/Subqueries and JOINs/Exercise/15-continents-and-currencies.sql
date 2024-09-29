SELECT c.continent_code, c.currency_code, COUNT(*) as currency_usage
FROM countries c
GROUP BY c.continent_code, c.currency_code
HAVING currency_usage > 1 AND currency_usage = (
			SELECT COUNT(*) as currency_usage
			FROM countries
			WHERE continent_code = c.continent_code
			GROUP BY currency_code
			ORDER BY currency_usage DESC
			LIMIT 1)
ORDER BY c.continent_code, c.currency_code;

