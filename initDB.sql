USE java_webapp_db;

CREATE TABLE `user` (
	ID varchar(255) primary key,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255),
    Country varchar(255)
);

CREATE TABLE `command` (
	ID varchar(255) primary key,

);

CREATE TABLE `commandLine` (
	lineNumber int,
	commandID varchar(255),
	primary key (lineNumber, commandID)
);

CREATE TABLE `article` (
	ID varchar(255) primary key,
	

);
    
    
    
