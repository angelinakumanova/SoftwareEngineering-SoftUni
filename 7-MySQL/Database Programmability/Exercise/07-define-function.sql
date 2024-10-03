DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS INT
NO SQL
BEGIN
	DECLARE output INT;
    SET output = (SELECT word REGEXP CONCAT('^[', set_of_letters, ']+$'));
    RETURN output;
END$$


DELIMITER ;


