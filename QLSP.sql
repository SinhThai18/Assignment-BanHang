CREATE DATABASE QLSP
USE QLSP

-- Tạo bảng Category
CREATE TABLE Category (
    cid INT PRIMARY KEY,
    cname NVARCHAR(255)
);

-- Tạo bảng Account
CREATE TABLE Account (
    uID INT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    isSell BIT,
    isAdmin BIT
);

-- Tạo bảng Product
CREATE TABLE Product (
    id INT PRIMARY KEY,
    name NVARCHAR(255),
    image VARCHAR(255),
    price DECIMAL(10, 2),
    description TEXT,
    cateID INT,
    sell_id INT,
    FOREIGN KEY (cateID) REFERENCES Category(cid),
    FOREIGN KEY (sell_id) REFERENCES Account(uID)
);

select*from Product