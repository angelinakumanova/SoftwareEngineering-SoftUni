DELIMITER $$
DROP FUNCTION udf_offers_from_city_name;
CREATE FUNCTION udf_offers_from_city_name (cityName VARCHAR(50))
RETURNS INT
READS SQL DATA
BEGIN
	RETURN (SELECT COUNT(*) FROM property_offers po
	JOIN properties p ON po.property_id = p.id
	JOIN cities c ON p.city_id = c.id
	WHERE c.name = cityName);
END$$

DELIMITER ;
SELECT udf_offers_from_city_name('Vienna') AS 'offers_count';

