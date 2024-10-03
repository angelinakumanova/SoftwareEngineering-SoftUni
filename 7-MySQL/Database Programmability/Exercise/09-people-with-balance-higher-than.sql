DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(number DECIMAL(12, 4))
BEGIN
	SELECT ah.first_name, ah.last_name FROM account_holders ah
	JOIN accounts a ON ah.id = a.account_holder_id
	GROUP BY ah.id
	HAVING SUM(a.balance) > number
	ORDER BY ah.id;
END$$


DELIMITER ;


