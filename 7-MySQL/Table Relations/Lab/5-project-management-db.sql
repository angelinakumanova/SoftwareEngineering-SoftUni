CREATE DATABASE project_management;
USE project_management;

CREATE TABLE clients (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_name VARCHAR(100)
);

CREATE TABLE projects (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_id INT,
    project_lead_id INT,
    
    FOREIGN KEY (client_id)
    REFERENCES clients(id)
);

CREATE TABLE employees (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    project_id INT,
    
    FOREIGN KEY (project_id)
    REFERENCES projects(id)
);

ALTER TABLE projects
ADD FOREIGN KEY (project_lead_id)
REFERENCES employees(id);
