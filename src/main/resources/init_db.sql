CREATE DATABASE MyProject;

CREATE TABLE users (
  id int NOT NULL UNIQUE AUTO_INCREMENT,
  full_name VARCHAR (30),
  login VARCHAR (30) NOT NULL UNIQUE,
  password VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE contacts (
  id int NOT NULL UNIQUE AUTO_INCREMENT,
  surname VARCHAR(30) NOT NULL,
  name VARCHAR (30) NOT NULL,
  patronymic VARCHAR(30) NOT NULL,
  mob_num VARCHAR (10) NOT NULL UNIQUE,
  home_num VARCHAR(10),
  address VARCHAR(30),
  email VARCHAR(30),
  owner int,
  PRIMARY KEY (id),
  FOREIGN KEY (owner) REFERENCES users(id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
);
