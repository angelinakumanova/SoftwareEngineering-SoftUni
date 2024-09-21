SELECT department_id, COUNT(id) as 'Number of employees'
FROM employees
GROUP BY department_id
ORDER BY department_id, `Number of employees`;
