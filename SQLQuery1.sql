select*from Product
select*from Account
select*from Category

INSERT INTO Account ([user], pass, isSell,isAdmin)
VALUES('mrA','1602',0,0),
('mrB','1602',1 ,0 ),
('mrC','1602',0 ,1 ),
('mrD','1602',1 ,1 )
EXEC sp_helpconstraint 'Product'

ALTER TABLE Product
DROP CONSTRAINT PK__Product__3213E83F9A433FCD;

DROP TABLE Account
DROP TABLE Product

CREATE TABLE account (
    uID INT IDENTITY(1,1) PRIMARY KEY,
    [user] VARCHAR(50) UNIQUE NOT NULL,
    pass VARCHAR(50) NOT NULL,
    isSell BIT ,
    isAdmin BIT
);

ALTER TABLE Product
ADD information NVARCHAR(MAX);

CREATE TABLE Product (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image VARCHAR(255),
    price DECIMAL(12,0) NOT NULL,
    description TEXT,
    cateID INT,
    sell_id INT,
    information NVARCHAR(MAX)
);

INSERT INTO Product (name, image, price, description, cateID, sell_id, information)
SELECT name, image, price, description, cateID, sell_id, information
FROM Product;

EXEC sp_rename 'Product1', 'Product';

INSERT INTO Product ([name], [image], price, [description], cateID, sell_id, information)
VALUES(?,?,?,?,?,?,?)

ALTER TABLE Product
ADD CONSTRAINT FK_Product_Account FOREIGN KEY (sell_id)
REFERENCES Account(uID);

INSERT INTO Product ([name], [image], price, [description], cateID, sell_id, information)
VALUES ('Tên sản phẩm', 'img/boo1.jpg', 100, 'Mô tả sản phẩm', 1, 2, 'Thông tin sản phẩm');
