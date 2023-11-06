CREATE TABLE court (
    court_id SERIAL PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    sport VARCHAR(45) NOT NULL,
    location VARCHAR(255) NOT NULL,
    price_per_hour DECIMAL(10, 2) NOT NULL,
    owner_id INT,
    latitude VARCHAR(100) NOT NULL,
    longitude VARCHAR(100) NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES users(user_id)
);