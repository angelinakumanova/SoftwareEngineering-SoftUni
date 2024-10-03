DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(12,4))
BEGIN
	START TRANSACTION;
    
    IF (money_amount <= 0 
    OR (SELECT balance FROM accounts WHERE id = account_id) < money_amount 
    OR (SELECT COUNT(*) FROM accounts WHERE id = account_id) = 0) THEN
		ROLLBACK;
	ELSE
		UPDATE accounts SET balance = balance - money_amount
        WHERE id = account_id;
        COMMIT;
	END IF;
END$$


DELIMITER ;
SELECT a.id, ah.id, a.balance FROM account_holders ah
JOIN accounts a ON ah.id = a.account_holder_id
WHERE a.id = 1;