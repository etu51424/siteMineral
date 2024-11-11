USE java_webapp_db;

DROP TABLE IF EXISTS order;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS order_detail;
DROP TABLE IF EXISTS mineral;
DROP TABLE IF EXISTS category;

CREATE TABLE `person` (
	-- ptete pas utile ici le not null
	user_id varchar(255) not null auto_increment primary key,
    last_name varchar(255) not null,
    first_name varchar(255) not null,
    address varchar(255) not null,
    country varchar(255),
    gender int not null,
    phone_number int not null,
    email varchar(255) not null,
    birth_date int
);

CREATE TABLE `order` (
	order_id varchar(255) not null auto_increment primary key,
	date date
);

-- command line
-- n'a pas une double clé primaire car chaq nouv commande avce ce command_id est juste un incrémentation à quantity
CREATE TABLE `order_detail` (
	quantity int,
	command_id varchar(255) not null auto_increment primary key
);

CREATE TABLE `mineral` (
	mineral_id varchar(255) not null auto_increment primary key,
    name_fr varchar(255) not null,
    name_fr varchar(255) not null,
    price float not null
);

CREATE TABLE `category` (
	-- couleur, transparence, densite (1-6), type geologique
	category_id int primary key,
	name_fr varchar(255) not null,
    name_en varchar(255) not null
);


    
    
    
