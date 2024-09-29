SELECT e.employee_id, e.first_name, 
CASE
	WHEN DATE(p.start_date) >= '2005-01-01' THEN NULL
    ELSE p.name
END AS project_name
FROM employees e
	JOIN employees_projects ep ON e.employee_id = ep.employee_id
	JOIN projects p ON p.project_id = ep.project_id
WHERE e.employee_id = 24
ORDER BY project_name;