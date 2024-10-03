CREATE TABLE logs(
	log_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    old_sum DECIMAL(12, 4),
    new_sum DECIMAL(12, 4)
);

DELIMITER $$
CREATE TRIGGER tr_on_new_entry
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO logs (account_id, old_sum, new_sum) VALUES
    (OLD.id, OLD.balance, NEW.balance);
END$$

DELIMITER ;
CREATE TABLE notification_emails (
	id INT PRIMARY KEY AUTO_INCREMENT,
    recipient INT,
    subject VARCHAR(255),
    body TEXT
);

DELIMITER $$
CREATE TRIGGER tr_logs_insert
AFTER INSERT
ON logs
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails(recipient, subject, body) VALUE
    (new.account_id, 
    CONCAT('Balance change for account: ', new.account_id),
    CONCAT('On ', DATE_FORMAT(NOW(), '%b %d %Y'), 'at ',
    DATE_FORMAT(NOW(), '%r'), ' your balance was changed from ',
    ROUND(new.old_sum, 0), ' to ', ROUND(new.new_sum, 0), '.'));
END$$