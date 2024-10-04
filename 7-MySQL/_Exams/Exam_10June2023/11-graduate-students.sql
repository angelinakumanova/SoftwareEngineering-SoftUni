DELIMITER $$
CREATE PROCEDURE udp_graduate_all_students_by_year (year_started INT) 
BEGIN
	UPDATE courses c
	JOIN students_courses sc ON c.id = sc.course_id
	JOIN students s ON sc.student_id = s.id
    SET s.is_graduated = TRUE
	WHERE YEAR(c.start_date) = year_started;
END$$








