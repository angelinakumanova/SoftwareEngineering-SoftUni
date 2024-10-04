DELIMITER $$
CREATE PROCEDURE udp_increase_salaries_by_country (country_name VARCHAR(40))
BEGIN
	UPDATE workers w
	JOIN countries_preserves cp ON cp.preserve_id = w.preserve_id
	JOIN countries c ON cp.country_id = c.id
    SET salary = salary * 1.05
	WHERE c.name = country_name;
END$$



