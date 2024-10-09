DELIMITER $$
CREATE PROCEDURE udp_courses_by_address  (address_name VARCHAR(100))
BEGIN
		SELECT 	
	a.name,
    cl.full_name,
    CASE
		WHEN c.bill <= 20 THEN 'Low'
        WHEN c.bill <= 30 THEN 'Medium'
        ELSE 'High'
	END AS level_of_bill,
    cr.make,
    cr.condition,
    ctg.name AS cat_name
	FROM addresses a
		JOIN courses c ON c.from_address_id = a.id
		JOIN clients cl ON c.client_id = cl.id
		JOIN cars cr ON c.car_id = cr.id
		JOIN categories ctg ON cr.category_id = ctg.id
	WHERE a.name = address_name
	ORDER BY cr.make, cl.full_name;
END$$

