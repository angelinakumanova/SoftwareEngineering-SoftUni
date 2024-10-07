SELECT t.name, a.name, CHAR_LENGTH(a.name) AS count_of_characters
FROM teams t
JOIN offices o ON t.office_id = o.id
JOIN addresses a ON o.address_id = a.id
WHERE NOT website IS NULL
ORDER BY t.name, a.name;