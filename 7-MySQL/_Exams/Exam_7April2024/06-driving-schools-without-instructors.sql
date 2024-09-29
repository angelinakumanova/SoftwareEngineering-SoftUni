SELECT ds.id, ds.name, c.brand
FROM driving_schools ds
	LEFT JOIN instructors_driving_schools dis ON ds.id = dis.driving_school_id
    JOIN cars c ON ds.car_id = c.id
WHERE dis.instructor_id IS NULL
ORDER BY c.brand, ds.id
LIMIT 5;