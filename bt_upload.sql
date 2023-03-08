CREATE DATABASE bt_upload;

USE bt_upload;

CREATE TABLE users(
	id INT AUTO_INCREMENT,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    
    PRIMARY KEY (id)
);

INSERT INTO users(email,password) VALUES ("cybersoft","java20");

CREATE TABLE foods(
	id INT AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT,
    price INT,
    instruction TEXT,
    category VARCHAR(255),
    image TEXT,
    
    primary key(id)
);

INSERT INTO foods(name,description,price,instruction,category,image) VALUES ("Pizza hải sản nhỏ","Topping gồm tôm, mực và cá hồi",89000,"Nên ăn lúc bánh còn nóng","pizza","pizza.jpg");
INSERT INTO foods(name,description,price,instruction,category,image) VALUES ("Hamburger gà đặc biệt","Thịt gà rán ăn kèm phô mai và rau",55000,"Cho thêm sốt nếu nhạt","buger","burger.jpg");
