SELECT p.id, p.name, COUNT(*) AS count
FROM orders_products op
	JOIN products p ON op.product_id = p.id
GROUP BY op.product_id
HAVING count >= 5
ORDER BY count DESC, p.name;