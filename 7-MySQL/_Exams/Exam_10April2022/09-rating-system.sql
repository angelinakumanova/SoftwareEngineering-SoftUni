SELECT 
	m.title,
    CASE
		WHEN mai.rating <= 4 THEN 'poor'
        WHEN mai.rating <= 7 THEN 'good'
        ELSE 'excellent'
	END AS rating,
    CASE
		WHEN mai.has_subtitles IS TRUE THEN 'english'
        ELSE '-'
	END AS subtitles,
    mai.budget
FROM movies_additional_info mai
JOIN movies m ON mai.id = m.movie_info_id
ORDER BY budget DESC;
