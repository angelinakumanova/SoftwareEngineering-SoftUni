DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(12,4))
BEGIN
	START TRANSACTION;
    
    IF (amount <= 0)
    OR (SELECT balance FROM accounts WHERE id = from_account_id) < amount 
    OR (SELECT COUNT(*) FROM accounts WHERE id IN (from_account_id, to_account_id)) < 2 THEN
		ROLLBACK;
	ELSE
		UPDATE accounts SET balance = balance - amount
        WHERE id = from_account_id;
        
        UPDATE accounts SET balance = balance + amount
        WHERE id = to_account_id;
        COMMIT;
	END IF;
END$$


DELIMITER ;