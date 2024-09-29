USE table_relations;

CREATE TABLE people (
	person_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100),
    salary DECIMAL(10, 2),
    passport_id INT UNIQUE
);

CREATE TABLE passports(
	passport_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    passport_number VARCHAR(50) NOT NULL
);

ALTER TABLE people
ADD FOREIGN KEY (passport_id)
REFERENCES passports(passport_id);

INSERT INTO passports VALUES
(101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

INSERT INTO people VALUES
(1, 'Roberto', 43300.00, 102),
(2, 'Tom', 56100.00, 103),
(3, 'Yana', 60200.00, 101);