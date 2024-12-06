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
    real_price FLOAT,
	is_paid BOOL NOT NULL DEFAULT false,

    CHECK (order_date >= '2024-01-01')
);

CREATE TABLE order_detail (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    order_mineral_id VARCHAR(255) NOT NULL REFERENCES order_mineral(id),
    mineral_id VARCHAR(255) NOT NULL REFERENCES mineral(id),
    quantity INT NOT NULL,
    CONSTRAINT unique_order_detail UNIQUE (order_mineral_id, mineral_id),

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
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	language_id INT NOT NULL REFERENCES language(id),
    category_id INT NOT NULL REFERENCES category(id),
    category_name VARCHAR(255),
    CONSTRAINT unique_category_translation UNIQUE (language_id, category_id)
);

CREATE TABLE mineral (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    density INT NOT NULL,
    price FLOAT NOT NULL,
    category_id INT NOT NULL REFERENCES category(id),
    image_path VARCHAR(255),

    CHECK (price >= 0),
    CHECK (density >= 1 AND density <= 10)
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

INSERT INTO mineral (name, density, price, category_id, image_path) VALUES
-- Éléments natifs
('Or', 10, 500.00, 1, 'images/or.jpg'),
('Argent', 10, 450.00, 1, 'images/argent.jpg'),
('Cuivre', 9, 50.00, 1, 'images/cuivre.jpg'),
('Soufre', 2, 5.00, 1, 'images/soufre.jpg'),
-- Sulfures
('Galène', 7, 20.00, 2, 'images/galene.jpg'),
('Blende', 4, 15.00, 2, 'images/blende.jpg'),
('Chalcopyrite', 6, 18.00, 2, 'images/chalcopyrite.jpg'),
('Cinnabar', 9, 25.00, 2, 'images/cinnabar.jpg'),
-- Oxydes
('Hématite', 5, 10.00, 3, 'images/hematite.jpg'),
('Magnétite', 7, 12.50, 3, 'images/magnetite.jpg'),
('Corindon', 9, 150.00, 3, 'images/corindon.jpg'),
('Spinelle', 8, 200.00, 3, 'images/spinelle.jpg'),
-- Halogénures
('Sylvine', 2, 4.00, 4, 'images/sylvine.jpg'),
('Cryolite', 3, 8.00, 4, 'images/cryolite.jpg'),
('Fluorine', 4, 15.00, 4, 'images/fluorine.jpg'),
('Halite', 2, 2.00, 4, 'images/halite.jpg'),
-- Carbonates
('Calcite', 3, 6.00, 5, 'images/calcite.jpg'),
('Dolomite', 4, 5.00, 5, 'images/dolomite.jpg'),
('Malachite', 5, 20.00, 5, 'images/malachite.jpg'),
('Azurite', 6, 25.00, 5, 'images/azurite.jpg'),
-- Sulfates
('Barytine', 7, 10.00, 6, 'images/barytine.jpg'),
('Anhydrite', 6, 8.00, 6, 'images/anhydrite.jpg'),
('Gypsum', 2, 4.50, 6, 'images/gypsum.jpg'),
('Célestine', 8, 12.00, 6, 'images/celestine.jpg'),
-- Phosphates
('Apatite', 4, 10.00, 7, 'images/apatite.jpg'),
('Monazite', 7, 25.00, 7, 'images/monazite.jpg'),
('Turquoise', 8, 80.00, 7, 'images/turquoise.jpg'),
('Variscite', 6, 50.00, 7, 'images/variscite.jpg'),
-- Silicates
('Quartz', 3, 5.00, 8, 'images/quartz.jpg'),
('Feldspath', 4, 7.00, 8, 'images/feldspath.jpg'),
('Topaze', 8, 50.00, 8, 'images/topaze.jpg'),
('Garnet', 9, 75.00, 8, 'images/garnet.jpg'),
-- Borates
('Borax', 2, 3.00, 9, 'images/borax.jpg'),
('Ulexite', 3, 6.00, 9, 'images/ulexite.jpg'),
('Colemanite', 4, 10.00, 9, 'images/colemanite.jpg'),
-- Hydroxides
('Goethite', 6, 10.00, 10, 'images/goethite.jpg'),
('Limonite', 4, 8.00, 10, 'images/limonite.jpg'),
('Diaspore', 7, 15.00, 10, 'images/diaspore.jpg'),
-- Nitrates
('Nitratine', 2, 5.00, 11, 'images/nitratine.jpg'),
('Nitrocalcite', 3, 7.00, 11, 'images/nitrocalcite.jpg'),
-- Minéraux organiques
('Ambre', 1, 20.00, 12, 'images/ambre.jpg'),
('Jais', 1, 30.00, 12, 'images/jais.jpg');
