DELIMITER $$
CREATE FUNCTION udf_count_flights_from_country(country VARCHAR(50))
RETURNS INT
READS SQL DATA
BEGIN
	RETURN(SELECT COUNT(*)
			FROM flights f
			JOIN countries c ON f.departure_country = c.id
			WHERE c.name = country
			GROUP BY c.name);

END$$

DELIMITER ;




