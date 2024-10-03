DELIMITER $$
DROP FUNCTION ufn_calculate_future_value;
CREATE FUNCTION ufn_calculate_future_value	
(sum DECIMAL(12, 4), yearly_interest_rate DOUBLE, number_of_years INT)
RETURNS DECIMAL(12,4)
NO SQL
BEGIN
	DECLARE result DECIMAL(12, 4);
	SET result = (SELECT sum * (POW((1 + yearly_interest_rate), number_of_years)));
    
    RETURN result;
END$$


DELIMITER ;
SELECT ufn_calculate_future_value(1000, 0.5, 5);

