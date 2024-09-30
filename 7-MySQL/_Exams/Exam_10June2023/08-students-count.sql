SELECT COUNT(*) AS students_count, u.name AS university_name
FROM students_courses sc
	JOIN courses c ON sc.course_id = c.id
    JOIN universities u ON c.university_id = u.id
GROUP BY u.name
HAVING students_count >= 8
ORDER BY students_count DESC, university_name DESC;