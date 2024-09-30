SELECT 
	t.id,
    t.capacity,
    COUNT(oc.client_id) AS count_clients,
    CASE
		WHEN t.capacity > COUNT(oc.client_id) THEN 'Free seats'
		WHEN t.capacity = COUNT(oc.client_id) THEN 'Full'
		ELSE 'Extra seats'
	END AS availability
FROM tables t
	JOIN orders o ON o.table_id = t.id
    JOIN orders_clients oc ON o.id = oc.order_id
WHERE t.floor = 1
GROUP BY t.id
ORDER BY t.id DESC;