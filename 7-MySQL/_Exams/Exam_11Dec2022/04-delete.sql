DELETE f
FROM flights f
LEFT JOIN flights_passengers fp ON f.id = fp.flight_id
WHERE fp.flight_id IS NULL;