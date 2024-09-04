-- Insert some users
INSERT INTO users (id, email) VALUES (1, 'user1@example.com');
INSERT INTO users (id, email) VALUES (2, 'user2@example.com');
INSERT INTO users (id, email) VALUES (3, 'user3@example.com');
INSERT INTO users (id, email) VALUES (4, 'admin@example.com');

-- Insert availability slots for the users
-- User 1 availability: Monday 10:00 AM - 1:00 PM and 4:00 PM - 6:00 PM
INSERT INTO availability_slots (id, user_id, start, end_time, duration) 
VALUES (1, 1, '2024-09-05T10:00:00', '2024-09-05T13:00:00', 180);

INSERT INTO availability_slots (id, user_id, start, end_time, duration) 
VALUES (2, 1, '2024-09-05T16:00:00', '2024-09-05T18:00:00', 120);

-- User 2 availability: Tuesday 9:00 AM - 12:00 PM
INSERT INTO availability_slots (id, user_id, start, end_time, duration) 
VALUES (3, 2, '2024-09-06T09:00:00', '2024-09-06T12:00:00', 180);

-- User 3 availability: Wednesday 2:00 PM - 5:00 PM
INSERT INTO availability_slots (id, user_id, start, end_time, duration) 
VALUES (4, 3, '2024-09-07T14:00:00', '2024-09-07T17:00:00', 180);

-- Admin doesn't have availability but can schedule sessions
