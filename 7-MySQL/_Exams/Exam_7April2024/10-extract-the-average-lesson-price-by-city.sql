DELIMITER $$
DROP FUNCTION udf_average_lesson_price_by_city;
CREATE FUNCTION  udf_average_lesson_price_by_city (name VARCHAR(40))
RETURNS VARCHAR(10)
READS SQL DATA
BEGIN
	RETURN (SELECT FORMAT(AVG(average_lesson_price), 2) FROM driving_schools ds
				JOIN cities c ON ds.city_id = c.id
				WHERE c.name = name
				GROUP BY c.name);
	
END$$


DELIMITER ;
SELECT  udf_average_lesson_price_by_city('London');
