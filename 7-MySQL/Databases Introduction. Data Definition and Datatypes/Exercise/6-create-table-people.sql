CREATE TABLE people (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture TEXT,
    height DOUBLE(10,2),
    weight DOUBLE(10,2),
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO people VALUES
(1, 'Kevin', 'TEST', 1.90, 90, 'm', '2000-01-01', '123'),
(2, 'Emma', 'TEST', 1.60, 55, 'f', '2000-01-01', '123'),
(3, 'John', 'TEST', 1.90, 55, 'f', '2000-01-01', '123'),
(4, 'Mia', 'TEST', 1.60, 90, 'm', '2000-01-01', '123'),
(5, 'Karolina', 'TEST', 1.60, 55, 'f', '2000-01-01', '123');