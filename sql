CREATE DATABASE event_booking;

USE event_booking;

CREATE TABLE events (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    location VARCHAR(100),
    date DATE
);

CREATE TABLE bookings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    name VARCHAR(100),
    email VARCHAR(100),
    FOREIGN KEY (event_id) REFERENCES events(id)
);

-- Sample data
INSERT INTO events (name, location, date) VALUES
('Tech Conference', 'New York', '2025-02-10'),
('Startup Expo', 'San Francisco', '2025-02-15');
