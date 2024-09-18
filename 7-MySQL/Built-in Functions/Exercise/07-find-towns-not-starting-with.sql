SELECT
	town_id,
	name
FROM towns
WHERE NOT name REGEXP '^[RBD]'
ORDER BY name;