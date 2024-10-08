SELECT d.first_name, d.last_name, c.make, c.model, c.mileage
FROM cars_drivers cd
JOIN cars c ON c.id = cd.car_id
JOIN drivers d ON d.id = cd.driver_id
WHERE NOT c.mileage IS NULL
ORDER BY c.mileage DESC, d.first_name;