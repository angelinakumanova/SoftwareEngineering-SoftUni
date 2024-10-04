DELIMITER $$
CREATE FUNCTION udf_average_salary_by_position_name (name VARCHAR(40)) 
RETURNS DECIMAL(16, 2)
READS SQL DATA
BEGIN
	RETURN (SELECT AVG(w.salary) FROM positions p
	JOIN workers w ON p.id = w.position_id
	WHERE p.name = name
	GROUP BY p.name);
END$$






