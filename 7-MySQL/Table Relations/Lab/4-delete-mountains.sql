USE table_relations;

CREATE TABLE mountains (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE peaks (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    mountain_id INT,
    
    FOREIGN KEY (mountain_id)
    REFERENCES mountains(id)
	ON DELETE CASCADE
);

INSERT INTO mountains(name) VALUES
('Rila'),
('Rodopi');

INSERT INTO peaks(name, mountain_id) VALUES
('Musala', 1),
('Golyam Perelik', 2);

DELETE FROM mountains WHERE id = 2;

