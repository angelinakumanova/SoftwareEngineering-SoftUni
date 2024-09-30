DELETE w
FROM waiters w
	LEFT JOIN orders o ON w.id = o.waiter_id
WHERE o.table_id IS NULL;