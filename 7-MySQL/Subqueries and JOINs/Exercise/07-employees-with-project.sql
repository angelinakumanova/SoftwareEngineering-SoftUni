SELECT e.employee_id, e.first_name, p.name as project_name FROM employees e
JOIN employees_projects ep
ON e.employee_id = ep.employee_id
JOIN projects p
ON p.project_id = ep.project_id
WHERE DATE(p.start_date) > '2002-08-13' AND end_date IS NULL
ORDER BY e.first_name, project_name
LIMIT 5;