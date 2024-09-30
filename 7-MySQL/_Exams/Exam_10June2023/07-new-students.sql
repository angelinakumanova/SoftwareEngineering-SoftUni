SELECT 
	CONCAT_WS(' ', s.first_name, s.last_name) AS full_name,
    SUBSTRING(s.email, 2, 10) AS username,
    REVERSE(s.phone) AS password
FROM students_courses sc
	RIGHT JOIN students s ON sc.student_id = s.id
WHERE sc.student_id IS NULL
ORDER BY password DESC;