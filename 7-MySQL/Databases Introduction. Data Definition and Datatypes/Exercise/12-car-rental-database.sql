CREATE DATABASE car_rental;
USE car_rental;

CREATE TABLE categories (
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    category VARCHAR(100), 
    daily_rate DOUBLE(5,2), 
    weekly_rate DOUBLE(5,2), 
    monthly_rate DOUBLE(5,2), 
    weekend_rate DOUBLE(5,2)
);

CREATE TABLE cars (
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    plate_number VARCHAR(50), 
    make VARCHAR(50), 
    model VARCHAR(100), 
    car_year DATE, 
    category_id INT, 
    doors INT, 
    picture BLOB, 
    car_condition VARCHAR(100), 
    available BOOLEAN
);

CREATE TABLE employees (
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    first_name VARCHAR(100), 
    last_name VARCHAR(100), 
    title VARCHAR(200), 
    notes TEXT
);

CREATE TABLE customers (
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    driver_licence_number INT, 
    full_name VARCHAR(200), 
    address VARCHAR(200), 
    city VARCHAR(100), 
    zip_code INT, 
    notes TEXT
);

CREATE TABLE rental_orders (
	id INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT, 
    employee_id INT, 
    customer_id INT, 
    car_id INT, 
    car_condition VARCHAR(100), 
    tank_level DOUBLE(5,2), 
    kilometrage_start INT, 
    kilometrage_end INT, 
    total_kilometrage INT, 
    start_date DATE, 
    end_date DATE, 
    total_days INT, 
    rate_applied DOUBLE(5,2), 
    tax_rate DOUBLE(5,2), 
    order_status VARCHAR(50), 
    notes TEXT
);

INSERT INTO categories(category, daily_rate, weekly_rate, monthly_rate, weekend_rate) VALUES
('SUV', 1.0, 2.0, 3.0, 4.0),
('Sedan', 1.0, 2.0, 3.0, 4.0),
('Sports Car', 1.0, 2.0, 3.0, 4.0);

INSERT INTO cars (plate_number, make, model, car_year, category_id, doors, picture, car_condition, available) VALUES 
('1234A', 'BMW', 'X6', '2022-01-01', 3, 4, 'PICTURE', 'EXCELLENT', true),
('1234A', 'Audi', 'RS6', '2022-01-01', 3, 4, 'PICTURE', 'EXCELLENT', true),
('1234A', 'Toyota', 'RAV4', '2022-01-01', 3, 4, 'PICTURE', 'EXCELLENT', true);

INSERT INTO employees (first_name, last_name, title, notes) VALUES
('Petur', 'Petrov', 'Seller', 'NOTES'),
('Georgi', 'Georgiev', 'Seller', 'NOTES'),
('Stamat', 'Stamatov', 'Seller', 'NOTES');

INSERT INTO customers (driver_licence_number, full_name, address, city, zip_code, notes) VALUES
(1234, 'Petur Georgiev', 'Address', 'City', 12345, 'NOTES'),
(1234, 'Georgi Petrov', 'Address', 'City', 12345, 'NOTES'),
(1234, 'Stamat Georgiev', 'Address', 'City', 12345, 'NOTES');

INSERT INTO rental_orders (employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes) VALUES
(1, 1, 1, 'EXCELLENT', 100.0, 1000, 1000, 1000, '2022-01-01', '2022-01-30', 29, 10.0, 10.0, 'Completed', 'NOTES'),
(2, 2, 2, 'EXCELLENT', 100.0, 1000, 1000, 1000, '2022-01-01', '2022-01-30', 29, 10.0, 10.0, 'Completed', 'NOTES'),
(3, 3, 3, 'EXCELLENT', 100.0, 1000, 1000, 1000, '2022-01-01', '2022-01-30', 29, 10.0, 10.0, 'Completed', 'NOTES');