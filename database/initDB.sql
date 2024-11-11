USE java_webapp_db;

DROP TABLE IF EXISTS order;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS order_detail;
DROP TABLE IF EXISTS mineral;
DROP TABLE IF EXISTS category;

CREATE TABLE `user` (
	-- ptete pas utile ici le not null
	id varchar(255) not null auto_increment primary key,
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
	id varchar(255) not null auto_increment primary key,
	date date
);

-- command line
-- n'a pas une double clé primaire car chaq nouv commande avce ce command_id est juste un incrémentation à quantity
CREATE TABLE `order_detail` (
	quantity int not null,
	order_id varchar(255) references order(id),
    mineral_id varchar(255) references mineral(id),
    primary_key (order_id, mineral_id)
);

CREATE TABLE `mineral` (
	id varchar(255) not null auto_increment primary key,
    name_fr varchar(255) not null,
    name_en varchar(255) not null,
    price float not null
);

CREATE TABLE `category` (
	-- couleur, transparence, densite (1-6), type geologique
	id int not null auto_increment primary key,
	name_fr varchar(255) not null,
    name_en varchar(255) not null
);


    
    
    
