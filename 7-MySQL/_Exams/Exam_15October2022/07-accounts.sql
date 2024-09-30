SELECT
	CONCAT(last_name, first_name, CHAR_LENGTH(first_name), 'Restaurant') AS username,
    CONCAT(REVERSE(SUBSTRING(email, 2, 12))) AS password
FROM waiters
WHERE NOT salary IS NULL
ORDER BY password DESC;