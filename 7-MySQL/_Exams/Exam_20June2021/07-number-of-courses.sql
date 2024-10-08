SELECT 
	c.id AS car_id,
	c.make,
    c.mileage,
    COUNT(cr.id) AS count_of_courses,
    ROUND(AVG(cr.bill), 2) AS avg_bill
FROM cars c
LEFT JOIN courses cr ON c.id = cr.car_id
GROUP BY c.id
HAVING NOT count_of_courses = 2
ORDER BY count_of_courses DESC, car_id;
