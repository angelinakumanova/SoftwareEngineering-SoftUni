DELIMITER $$
CREATE FUNCTION udf_game_info_by_name (game_name VARCHAR (20))
RETURNS TEXT
READS SQL DATA
BEGIN
	DECLARE result TEXT;
	DECLARE team_name VARCHAR(50);
	DECLARE address_name VARCHAR(50);
    
	SET team_name = (SELECT name FROM teams WHERE
					id = (SELECT team_id FROM games WHERE name = game_name));
                        
	
	SET address_name = (SELECT a.name FROM games g
						JOIN teams t ON g.team_id = t.id
						JOIN offices o ON t.office_id = o.id
						JOIN addresses a ON o.address_id = a.id
						WHERE g.name = game_name);
                        
	SET result = CONCAT_WS(' ',
    'The', game_name, 'is developed by a',
    team_name, 'in an office with an address', address_name);
    
    RETURN result;
END$$

