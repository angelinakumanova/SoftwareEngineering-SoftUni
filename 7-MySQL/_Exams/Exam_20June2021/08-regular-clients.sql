SELECT c.full_name, COUNT(cr.car_id) AS count_of_cars, SUM(cr.bill) AS total_sum
FROM clients c
JOIN courses cr ON c.id = cr.client_id
WHERE SUBSTRING(c.full_name, 2, 1) = 'a'
GROUP BY c.full_name
HAVING count_of_cars > 1
ORDER BY full_name;