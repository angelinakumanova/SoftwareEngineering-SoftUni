DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(town_name_letter VARCHAR(10))
BEGIN
	SELECT name FROM towns
    WHERE name LIKE CONCAT(town_name_letter, '%')
    ORDER BY name;
END$$

DELIMITER ;
DROP PROCEDURE usp_get_towns_starting_with;

CALL usp_get_towns_starting_with('b');
