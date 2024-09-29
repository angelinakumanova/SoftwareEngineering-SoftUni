UPDATE driving_schools
SET average_lesson_price = average_lesson_price + 30
WHERE city_id = (SELECT id FROM cities WHERE name = 'London');
