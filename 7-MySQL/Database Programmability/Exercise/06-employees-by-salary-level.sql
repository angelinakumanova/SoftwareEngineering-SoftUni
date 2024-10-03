DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19,4))
RETURNS VARCHAR(20)
NO SQL
BEGIN
	DECLARE result VARCHAR(20);	
	 SET result = CASE 
        WHEN salary < 30000 THEN 'Low'
        WHEN salary <= 50000 THEN 'Average'
        ELSE 'High'
    END;
    
    RETURN result;
END$$

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(20))
BEGIN
	SELECT first_name, last_name 
	FROM employees
	WHERE salary_level = (SELECT ufn_get_salary_level(salary))
	ORDER BY first_name DESC, last_name DESC;
END$$


DELIMITER ;
DROP PROCEDURE usp_get_employees_by_salary_level;
CALL usp_get_employees_by_salary_level('High');

