DELIMITER $$
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20)) 
RETURNS INT
READS SQL DATA
BEGIN
	RETURN (SELECT COUNT(*)
	FROM clients c
	JOIN courses cr ON c.id = cr.client_id
	WHERE phone_number = phone_num);

END$$
