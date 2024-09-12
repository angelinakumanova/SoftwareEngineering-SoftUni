CREATE DATABASE movies;
USE movies;

CREATE TABLE directors(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    director_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE genres(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    genre_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE categories(
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    category_name VARCHAR(100) NOT NULL,
    notes TEXT
);

CREATE TABLE movies (
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    director_id INT,
    copyright_year DATE,
    length DOUBLE(10, 2),
    genre_id INT,
    category_id INT,
    rating DOUBLE(10,2),
    notes TEXT
);

INSERT INTO directors(director_name, notes) VALUES 
('Petur', 'NOTES'),
('Gosho', 'NOTES'),
('Ivan', 'NOTES'),
('Stamat', 'NOTES'),
('Gergana', 'NOTES');

INSERT INTO genres(genre_name, notes) VALUES 
('Sci-Fi', 'NOTES'),
('Thriller', 'NOTES'),
('Romantic', 'NOTES'),
('Action', 'NOTES'),
('Drama', 'NOTES');

INSERT INTO categories(category_name, notes) VALUES 
('Above 18', 'NOTES'),
('Under 18', 'NOTES'),
('Ivan', 'NOTES'),
('Stamat', 'NOTES'),
('Gergana', 'NOTES');

INSERT INTO movies VALUES
(1, 'Movie 1', 5, '2024-01-01', 2.20, 5, 1, 5.00, 'NOTES'),
(2, 'Movie 2', 4, '2024-01-01', 2.20, 4, 2, 5.00, 'NOTES'),
(3, 'Movie 3', 3, '2024-01-01', 2.20, 3, 3, 5.00, 'NOTES'),
(4, 'Movie 4', 2, '2024-01-01', 2.20, 2, 4, 5.00, 'NOTES'),
(5, 'Movie 5', 1, '2024-01-01', 2.20, 1, 5, 5.00, 'NOTES');
