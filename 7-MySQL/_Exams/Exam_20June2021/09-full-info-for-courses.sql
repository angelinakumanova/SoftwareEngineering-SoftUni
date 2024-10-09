SELECT 
	a.name,
	CASE
		WHEN HOUR(c.start) BETWEEN 6 AND 20 THEN 'Day'
        ELSE 'Night'
	END AS day_time,
    c.bill,
    cl.full_name,
	cr.make,
    cr.model,
    ctg.name AS category_name
FROM courses c
JOIN addresses a ON c.from_address_id = a.id
JOIN clients cl ON c.client_id = cl.id
JOIN cars cr ON c.car_id = cr.id
JOIN categories ctg ON cr.category_id = ctg.id
ORDER BY c.id;