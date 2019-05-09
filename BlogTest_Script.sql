DROP DATABASE IF EXISTS blog;

CREATE DATABASE blog;

USE blog;

CREATE TABLE tag (
id int primary key auto_increment,
`title` varchar(50) not null
);

CREATE TABLE category (
id int primary key auto_increment,
`title` varchar(30) not null,
`description` varchar(255)
);

CREATE TABLE author (
id int primary key auto_increment,
`name` varchar(50) not null,
userName varchar(25) not null,
password varchar(20) not null,
restrictions varchar(255) not null
);

CREATE TABLE post (
id int primary key auto_increment,
authorId int not null,
`title` varchar(100) not null,
`content` text,
`date` date,
foreign key(authorId) references author(id)
);

CREATE TABLE `comment` (
id int primary key auto_increment,
postId int not null,
authorId int not null,
`date` date,
`content` text,
foreign key(postId) references post(id),
foreign key(authorId) references author(id)
);

CREATE TABLE post_category (
postId int not null,
categoryId int not null,
primary key(postId, categoryId),
foreign key(postId) references post(id),
foreign key(categoryId) references category(id)
);

CREATE TABLE post_tag (
postId int not null,
tagId int not null,
primary key(postId, tagId),
foreign key(postId) references post(id),
foreign key(tagId) references tag(id)
);





