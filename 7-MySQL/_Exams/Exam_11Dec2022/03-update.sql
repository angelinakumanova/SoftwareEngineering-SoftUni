UPDATE flights
SET airplane_id = airplane_id + 1
WHERE departure_country = (SELECT id FROM countries WHERE name = 'Armenia');