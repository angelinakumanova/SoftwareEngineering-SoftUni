DELIMITER $$
CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
RETURNS INT
READS SQL DATA
BEGIN
	RETURN(SELECT COUNT(op.product_id)
	FROM customers c
	JOIN orders o ON c.id = o.customer_id
	JOIN orders_products op ON o.id = op.order_id
	WHERE c.first_name = name);
END$$
