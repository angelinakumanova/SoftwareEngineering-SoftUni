CREATE TABLE users (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture TEXT,
    last_login_time DATETIME,
    is_deleted BOOLEAN
);

INSERT INTO users(username, password, profile_picture, last_login_time, is_deleted) VALUES
('Bobar123', '123456', 'Bobar', '2024-09-12 09:22:40', false),
('PeturP', '123456', NULL, '2024-09-12 09:22:40', false),
('IvanIv', '123456', NULL, '2024-09-12 09:22:40', false),
('GeorgiG', '123456', 'PICTURE', '2024-09-12 09:22:40', false),
('IvanetaK', '123456', 'PICTURE', '2024-09-12 09:22:40', false);
