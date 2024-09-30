SELECT c.name, c.currency, COUNT(*) AS booked_tickets
FROM flights_passengers fp
	JOIN flights f ON fp.flight_id = f.id
    JOIN countries c ON f.destination_country = c.id
GROUP BY f.destination_country
HAVING booked_tickets >= 20
ORDER BY booked_tickets DESC;