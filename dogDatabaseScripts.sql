-- Drop existing tables
DROP TABLE IF EXISTS Items, Users, Categories, Manufacturers;

-- Create Manufacturers table
CREATE TABLE IF NOT EXISTS Manufacturers (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
-- Populate Manufacturers table
INSERT INTO Manufacturers (name) VALUES 
('Hurtta'),
('Royal Canin'),
('Pro Dog');

-- Create Categories table
CREATE TABLE IF NOT EXISTS Categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
-- Populate Categories table
INSERT INTO Categories (name) VALUES 
('Clothing'),
('Food'),
('Toys');

-- Create Items table
CREATE TABLE IF NOT EXISTS Items (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    color VARCHAR(255),
    size VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    manufacturer_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    FOREIGN KEY (manufacturer_id) REFERENCES Manufacturers(id),
    FOREIGN KEY (category_id) REFERENCES Categories(id)
);
-- Populate Items table
INSERT INTO Items (name, color, size, price, stock, manufacturer_id, category_id) VALUES 
('Dog jacket', 'Blue', 'Medium', 26.95, 10, 1, 1),
('Dog food', '-', '-', 10.49, 10, 2, 2),
('Dog toy', 'Orange', '-', 7.95, 5, 3, 3);

-- Create Users table
CREATE TABLE IF NOT EXISTS Users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    role VARCHAR(255) NOT NULL
);
-- Populate Users table
INSERT INTO Users (username, password, email, role) VALUES 
('admin', '$2a$12$aQLOSgr68.ZYV71E32Hb/Ou3nO5uMS3fO/z3wp9hYsbCeJFKjr9fy', 'admin@admin.com', 'ADMIN');
