INSERT INTO products
(name, type, price)
SELECT
	CONCAT_WS(' ', last_name, 'specialty') AS name,
    'Cocktail' AS type,
    CEIL(salary * 0.01) AS price
FROM waiters
WHERE id > 6;