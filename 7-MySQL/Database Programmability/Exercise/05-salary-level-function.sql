DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19,4))
RETURNS VARCHAR(20)
READS SQL DATA
BEGIN
	DECLARE result VARCHAR(20);	
	 SET result = CASE 
        WHEN salary < 30000 THEN 'Low'
        WHEN salary <= 50000 THEN 'Average'
        ELSE 'High'
    END;
    
    RETURN result;
END$$

DELIMITER ;
SELECT ufn_get_salary_level(13500.00);
SELECT ufn_get_salary_level(43300.00);

