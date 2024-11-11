USE java_webapp_db;

DROP TABLE IF EXISTS order_detail;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS mineral;
DROP TABLE IF EXISTS order_mineral;
DROP TABLE IF EXISTS person;

CREATE TABLE person (
	-- ptete pas utile ici le not null
	id INT not null auto_increment primary key,
    last_name varchar(255) not null,
    first_name varchar(255) not null,
    address varchar(255) not null,
    country varchar(255),
    gender int not null,
    phone_number int not null,
    email varchar(255) not null,
    birth_date int
);

CREATE TABLE order_mineral (
	id INT not null auto_increment primary key,
	order_date date
);

-- command line
-- n'a pas une double clé primaire car chaq nouv commande avce ce command_id est juste un incrémentation à quantity
CREATE TABLE order_detail (
	quantity int not null,
	order_mineral_id varchar(255) references order_mineral(id),
    mineral_id varchar(255) references mineral(id),
    PRIMARY KEY pk_order_detail (order_mineral_id, mineral_id)
);

CREATE TABLE mineral (
	id INT not null auto_increment primary key,
    name_fr varchar(255) not null,
    name_en varchar(255) not null,
    color_fr varchar(255) not null,
    color_en varchar(255) not null,
    transparence_fr varchar(255) not null, -- check que c dans une liste
    transparence_en varchar(255) not null,
    densite int not null,
    price float not null
);

-- correspond au type geologique
CREATE TABLE categorie (
	-- couleur, transparence, densite (1-6), type geologique
	id int not null auto_increment primary key,
	name_fr varchar(255) not null,
    name_en varchar(255) not null
);


    
    
    
