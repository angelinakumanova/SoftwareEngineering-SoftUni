DELIMITER $$
CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60)) 
RETURNS DECIMAL (6, 2)
READS SQL DATA
BEGIN
	RETURN(SELECT AVG(sc.grade)
			FROM courses c
			JOIN students_courses sc ON c.id = sc.course_id
			JOIN students s ON sc.student_id = s.id
			WHERE c.name = course_name AND s.is_graduated IS TRUE
			GROUP BY c.name);
END$$





