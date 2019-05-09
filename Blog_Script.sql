DROP DATABASE IF EXISTS blog;

CREATE DATABASE blog;

USE blog;

CREATE TABLE `user` (
id int primary key auto_increment,
username varchar(20) not null,
`password` varchar(80) not null,
enabled boolean not null
);

CREATE TABLE tag (
id int primary key auto_increment,
`name` varchar(25) not null
);

CREATE TABLE category (
id int primary key auto_increment,
`name` varchar(25) not null
);

CREATE TABLE post (
id int primary key auto_increment,
userid int not null,
categoryid int not null,
`title` varchar(100) not null,
`content` text,
`date` date,
status varchar(10) not null,
foreign key(userid) references `user`(id),
foreign key(categoryid) references category(id) 
);

CREATE TABLE `role` (
id int primary key auto_increment,
`role` varchar(30) not null
);

CREATE TABLE post_tag (
postid int not null,
tagid int not null,
primary key(postid, tagid),
foreign key(postid) references post(id),
foreign key(tagid) references tag(id)
);

CREATE TABLE user_role (
userid int not null,
roleid int not null,
primary key(userid, roleid),
foreign key(userid) references `user`(id),
foreign key(roleid) references `role`(id)
);






