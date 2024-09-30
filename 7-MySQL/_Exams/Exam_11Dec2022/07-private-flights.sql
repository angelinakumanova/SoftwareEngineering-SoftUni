SELECT 
	CONCAT(UPPER(LEFT(p.last_name, 2)), p.country_id) AS flight_code,
    CONCAT_WS(' ', p.first_name, p.last_name) AS full_name,
    p.country_id
FROM passengers p
	LEFT JOIN flights_passengers fp ON p.id = fp.passenger_id
WHERE fp.passenger_id IS NULL
ORDER BY p.country_id;