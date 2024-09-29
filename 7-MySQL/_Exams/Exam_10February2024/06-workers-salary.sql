SELECT w.id, w.first_name, w.last_name, p.name, c.country_code
FROM workers w
	JOIN preserves p ON w.preserve_id = p.id
    JOIN countries_preserves cp ON p.id = cp.preserve_id
    JOIN countries c ON cp.country_id = c.id
WHERE w.salary > 5000 AND w.age < 50
ORDER BY c.country_code;