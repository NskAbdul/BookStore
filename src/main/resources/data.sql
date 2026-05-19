INSERT INTO authors (id, name, biography, created_at, updated_at) VALUES (1, 'George Orwell', 'English novelist and essayist.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO authors (id, name, biography, created_at, updated_at) VALUES (2, 'J.K. Rowling', 'British author, best known for the Harry Potter series.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO categories (id, name, description, created_at, updated_at) VALUES (1, 'Dystopian', 'Dystopian fiction', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, name, description, created_at, updated_at) VALUES (2, 'Fantasy', 'Fantasy fiction', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO books (id, title, isbn, description, price, stock_quantity, published_date, language, rating, author_id, category_id, created_at, updated_at) 
VALUES (1, '1984', '9780451524935', 'A dystopian social science fiction novel and cautionary tale.', 9.99, 50, '1949-06-08', 'English', 4.8, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO books (id, title, isbn, description, price, stock_quantity, published_date, language, rating, author_id, category_id, created_at, updated_at) 
VALUES (2, 'Harry Potter and the Sorcerer''s Stone', '9780590353403', 'The first novel in the Harry Potter series.', 14.99, 100, '1997-06-26', 'English', 4.9, 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Password is 'password123' encrypted with BCrypt
INSERT INTO users (id, username, email, password, created_at, updated_at) 
VALUES (1, 'admin', 'admin@bookstore.com', '$2a$10$3s8/Z/a59a9Y4aB.U/uW4.Y6A2w1L2w1lXk1r5H1f4k9N9m9K9K9K', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO user_roles (user_id, role) VALUES (1, 'ROLE_ADMIN');
