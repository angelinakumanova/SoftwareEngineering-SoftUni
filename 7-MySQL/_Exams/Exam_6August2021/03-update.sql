UPDATE employees e
JOIN teams t ON e.id = t.leader_id
SET e.salary = e.salary + 1000
WHERE e.age <= 40 AND salary < 5000;