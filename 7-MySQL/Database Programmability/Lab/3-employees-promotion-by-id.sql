DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
	DECLARE e_count INT;
	SET e_count = (SELECT COUNT(*) FROM employees WHERE employee_id = id);
	
    START TRANSACTION;
    
    UPDATE employees AS e 
    SET salary = salary * 1.05
	WHERE e.employee_id = id;
    
	IF (e_count = 0) THEN 
		ROLLBACK;
	ELSE 
		COMMIT;
	END IF;
END$$




