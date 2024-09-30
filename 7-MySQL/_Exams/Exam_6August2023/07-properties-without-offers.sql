SELECT 
	TRIM(SUBSTRING(REGEXP_REPLACE(p.address, '[0-9]+', ''), 1, 6)) AS agent_name,
    CHAR_LENGTH(p.address) * 5430 AS price
FROM property_offers po
	RIGHT JOIN properties p ON po.property_id = p.id
WHERE po.property_id IS NULL
ORDER BY agent_name DESC, price DESC;