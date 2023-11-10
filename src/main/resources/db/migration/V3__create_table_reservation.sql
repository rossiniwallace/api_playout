CREATE TABLE reservation (
    reservation_id SERIAL PRIMARY KEY,
    court_id INT,
    client_id INT,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (court_id) REFERENCES court(court_id),
    FOREIGN KEY (client_id) REFERENCES users(user_id)
);