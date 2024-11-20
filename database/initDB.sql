-- CREATE DATABASE java_webapp_db;
USE java_webapp_db;

DROP TABLE IF EXISTS order_detail;
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
    authorities VARCHAR(25) NOT NULL DEFAULt 'ROLE_USER',
    non_expired BOOL DEFAULT NULL,
    non_locked BOOL DEFAULT NULL,
    credentials_non_expired BOOL DEFAULT NULL,
    enabled BOOL DEFAULT NULL,

    CHECK (birth_date >= '1900-01-01'),
    CHECK (gender in ('M', 'F', 'X')),
    CHECK (authorities in ('ROLE_USER', 'ROLE_ADMIN'))
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

CREATE TABLE category (
	--  type geologique
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name_fr VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL
);

CREATE TABLE mineral (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name_fr VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    color_fr VARCHAR(255) NOT NULL,
    color_en VARCHAR(255) NOT NULL,
    transparence_fr VARCHAR(255) NOT NULL,
    transparence_en VARCHAR(255) NOT NULL,
    densite INT NOT NULL,
    price FLOAT NOT NULL,
    category_id INT NOT NULL REFERENCES category(id),
    
    CHECK (transparence_fr in ('transparent','semi-transparent','translucide', 'opaque')),
    CHECK (transparence_en in ('transparent','semi-transparent','translucent','opaque')),
    CHECK (price >= 0),
    CHECK (densite >= 1 AND densite <= 10)
);
