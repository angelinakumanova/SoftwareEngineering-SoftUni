INSERT INTO students (first_name, last_name, age, phone_number)
SELECT 
    LOWER(REVERSE(first_name)) AS first_name, 
    LOWER(REVERSE(last_name)) AS last_name,  
    age + CAST(SUBSTRING(phone_number, 1, 1) AS UNSIGNED) AS age,  
    CONCAT('1+', phone_number) AS phone_number 
FROM students
WHERE age < 20;