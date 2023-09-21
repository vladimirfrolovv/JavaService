CREATE TABLE clients
(
    id SERIAL,
    login VARCHAR,
    email VARCHAR,
    password VARCHAR,
    registered BOOLEAN
);
INSERT INTO clients (login, email, password, registered)  VALUES ('vovan', 'email', 'qwerty', false);


