-- CREATE DATABASE java_webapp_db;
set @@global.time_zone  = '+00:00' ; 
set @@session.time_zone = '+00:00' ;
USE java_webapp_db;

DROP TABLE IF EXISTS order_detail;
DROP TABLE IF EXISTS category_translation;
DROP TABLE IF EXISTS language;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS mineral;
DROP TABLE IF EXISTS order_mineral;
DROP TABLE IF EXISTS person;

CREATE TABLE person (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    gender CHAR,
    birth_date DATE,
    password VARCHAR(255) NOT NULL,
    authorities VARCHAR(25) DEFAULt NULL,
    non_expired BOOL DEFAULT NULL,
    non_locked BOOL DEFAULT NULL,
    credentials_non_expired BOOL DEFAULT NULL,
    enabled BOOL DEFAULT NULL,

    CHECK (birth_date >= '1900-01-01'),
    CHECK (gender in ('M', 'F', 'X', null))
);

CREATE TABLE order_mineral (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        person_id INT NOT NULL REFERENCES person(id),
	order_date DATE,
	is_paid BOOL NOT NULL DEFAULT false,

    CHECK (order_date >= '2024-01-01')
);

CREATE TABLE order_detail (
    order_mineral_id VARCHAR(255) NOT NULL REFERENCES order_mineral(id),
    mineral_id VARCHAR(255) NOT NULL REFERENCES mineral(id),
    quantity INT NOT NULL,
    PRIMARY KEY pk_order_detail (order_mineral_id, mineral_id),

    CHECK (quantity >= 1)
);

CREATE TABLE language(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    label VARCHAR(100) NOT NULL
);

CREATE TABLE category (
	--  type geologique
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE category_translation(
	language_id INT NOT NULL REFERENCES language(id),
    category_id INT NOT NULL REFERENCES category(id),
    category_name VARCHAR(255),
    CONSTRAINT pk_category_translation PRIMARY KEY (language_id, category_id)
);

CREATE TABLE mineral (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    densite INT NOT NULL,
    price FLOAT NOT NULL,
    category_id INT NOT NULL REFERENCES category(id),
    imagePath VARCHAR(255),

    CHECK (price >= 0),
    CHECK (densite >= 1 AND densite <= 10)
);

INSERT INTO person (username,last_name,first_name,address,email,phone_number,password,authorities,non_expired,non_locked,credentials_non_expired,enabled) 
VALUES ('jean', 'jean', 'michel', '1 rue du rocher', 'rocher.cailloux@rock.be', '0123456789', '$2a$10$mZvOb3kqbxrbL7FbGS30pe3H/Bu9QkAQtgwsohAdHKc55a8frs7li', 'ROLE_USER', 1 , 1, 1, 1),
('admin', 'admin', 'admin', '1 rue du rocher', 'rocher.cailloux@rock.be', '0123456789', '$2a$10$mZvOb3kqbxrbL7FbGS30pe3H/Bu9QkAQtgwsohAdHKc55a8frs7li', 'ROLE_ADMIN', 1 , 1, 1, 1);

INSERT INTO language(label) VALUES 
('Francais'),
('English');

INSERT INTO category() VALUES 
(),
(),
(),
(),
(),
(),
(),
(),
(),
(),
(),
();

INSERT INTO category_translation(language_id, category_id, category_name) VALUES 
(1, 1, 'Éléments natifs'),
(2, 1, 'Native elements'),
(1, 2, 'Sulfides'),
(2, 2, 'Sulphides'),
(1, 3, 'Oxides'),
(2, 3, 'Oxides'),
(1, 4, 'Halides'),
(2, 4, 'Halides'),
(1, 5, 'Carbonates'),
(2, 5, 'Carbonates'),
(1, 6, 'Sulfates'),
(2, 6, 'Sulfates'),
(1, 7, 'Phosphates'),
(2, 7, 'Phosphates'),
(1, 8, 'Silicates'),
(2, 8, 'Silicates'),
(1, 9, 'Borates'),
(2, 9, 'Borates'),
(1, 10, 'Hydroxides'),
(2, 10, 'Hydroxides'),
(1, 11, 'Nitrates'),
(2, 11, 'Nitrates'),
(1, 12, 'Minéraux organiques'),
(2, 12, 'Organic minerals');
