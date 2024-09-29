SELECT p.name, COUNT(*) AS armed_workers
FROM countries_preserves cp
	JOIN preserves p ON cp.preserve_id = p.id
    JOIN workers w ON p.id = w.preserve_id
WHERE w.is_armed = 1
GROUP BY p.name
ORDER BY armed_workers DESC, p.name;