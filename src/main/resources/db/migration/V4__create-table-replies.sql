CREATE TABLE replies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL,
    topic_id BIGINT,
    creation_date TIMESTAMP NOT NULL,
    user_id BIGINT,
    solution BOOLEAN NOT NULL,
    FOREIGN KEY (topic_id) REFERENCES topics(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);