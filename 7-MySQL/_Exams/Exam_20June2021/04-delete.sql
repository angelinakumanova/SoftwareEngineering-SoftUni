DELETE c FROM clients c
LEFT JOIN courses cr ON c.id = cr.client_id
WHERE cr.client_id IS NULL AND CHAR_LENGTH(c.full_name) >= 3;