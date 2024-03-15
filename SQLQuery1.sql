CREATE DATABASE QLSP2
USE QLSP2

DROP TABLE Product
DROP TABLE Category
DROP TABLE Account

SELECT*FROM Product
SELECT*FROM Category
SELECT*FROM Account
SELECT*FROM [Order]
SELECT*FROM [OrderLine]


/*-----------------------------Account------------------------------------------------*/
CREATE TABLE Account (
    [uID] INT IDENTITY(1,1) PRIMARY KEY,
    [user] VARCHAR(50) UNIQUE NOT NULL,
    pass VARCHAR(50) NOT NULL,
    isSell BIT ,
    isAdmin BIT
);
/*-----------------------------------------------------------------------------*/


/*-----------------------------Category------------------------------------------------*/
CREATE TABLE Category(
     cid INT  PRIMARY KEY,
	 cname NVARCHAR,
);
ALTER TABLE Category
ALTER COLUMN cname NVARCHAR(50);

/*-----------------------------------------------------------------------------*/



/*-----------------------------PRODUCTT------------------------------------------------*/
CREATE TABLE Product (
    id INT IDENTITY(1,1) PRIMARY KEY,
    [name] VARCHAR(255) NOT NULL,
    [image] VARCHAR(255),
    price DECIMAL(12,0) NOT NULL,
    [description] TEXT,
    cateID INT  FOREIGN KEY (cateID) REFERENCES Category(cid),
    sell_id INT FOREIGN KEY (sell_id) REFERENCES Account(uID),
    information NVARCHAR(MAX)
);

UPDATE Product
SET quantity = 10;
UPDATE Product
SET name='ABA',
image='AB',
price=10,
description='A',
cateID=1,
sell_id=2,
information='1'
WHERE id=1

SELECT*FROM Product
WHERE sell_id = 2

ALTER TABLE Product
ADD quantity INT;

/*-------------------------------------------------------------------------*/


/*-----------------------------ORDER------------------------------------------------*/
CREATE TABLE [Order] (
    oid INT IDENTITY(1,1) PRIMARY KEY,
    [date] DATE NOT NULL,
	[uID] INT NOT NULL FOREIGN KEY ([uID]) REFERENCES Account(uID),
	totalmoney DECIMAL(18,0) NOT NULL
);

/*-----------------------------------------------------------------------------*/


/*-----------------------------ORDERLINE------------------------------------------------*/
CREATE TABLE [OrderLine] (
    oid INT FOREIGN KEY (oid) REFERENCES [Order]( oid ),
    pid INT FOREIGN KEY (pid) REFERENCES [Product](id),
	quantity INT,
	price DECIMAL(12,0) NOT NULL
);
/*-----------------------------------------------------------------------------*/

INSERT INTO Account ([user], pass, isSell,isAdmin)
VALUES('mrA','1602',0,0),
('mrB','1602',1 ,0 ),
('mrC','1602',0 ,1 ),
('mrD','1602',1 ,1 )
ALTER TABLE Account
ADD phone VARCHAR(20);
UPDATE Account
SET phone = '0123456789'
WHERE [user] = 'mrA';

UPDATE Account
SET phone = '0987654321'
WHERE [user] = 'mrB';

UPDATE Account
SET phone = '0345678901'
WHERE [user] = 'mrC';

UPDATE Account
SET phone = '0909090909'
WHERE [user] = 'mrD';

INSERT INTO Account ([user], pass, isSell,isAdmin)
VALUES('mre','1602',0,0)

INSERT INTO Category (cid, cname)
VALUES
(1, 'Boo'),
(2, 'Coins'),
(3, 'Lemon'),
(4, 'Teelab');

INSERT INTO Product (name, image, price, description, cateID, sell_id, information)
VALUES
( 'Boo1', 'img\Boo1.jpg', 200000.00, 'áo thun Boo', 1, NULL, 'Marking the milestone of 20 years, BOO integrates the cultural essence of Vietnamese street culture into fashion products for the youth. BOO aspires to continue spreading the spirit of daring to think and daring to do through its 20th-anniversary collection'),
( 'Boo2', 'img\Boo2.jpg', 150000.00, 'áo thun Boo', 1, NULL, 'Marking the milestone of 20 years, BOO integrates the cultural essence of Vietnamese street culture into fashion products for the youth. BOO aspires to continue spreading the spirit of daring to think and daring to do through its 20th-anniversary collection'),
('Boo3', 'img\Boo3.jpg', 220000.00, 'áo thun Boo', 1, NULL, 'Marking the milestone of 20 years, BOO integrates the cultural essence of Vietnamese street culture into fashion products for the youth. BOO aspires to continue spreading the spirit of daring to think and daring to do through its 20th-anniversary collection'),
( 'Boo4', 'img\Boo4.jpg', 150000.00, 'áo thun Boo', 1, NULL, 'Marking the milestone of 20 years, BOO integrates the cultural essence of Vietnamese street culture into fashion products for the youth. BOO aspires to continue spreading the spirit of daring to think and daring to do through its 20th-anniversary collection'),
( 'Boo5', 'img\Boo5.jpg', 300000.00, 'áo cardigan Boo', 1, NULL, 'Marking the milestone of 20 years, BOO integrates the cultural essence of Vietnamese street culture into fashion products for the youth. BOO aspires to continue spreading the spirit of daring to think and daring to do through its 20th-anniversary collection'),
( 'Boo6', 'img\Boo6.jpg', 120000.00, 'áo thun Boo', 1, NULL, 'Marking the milestone of 20 years, BOO integrates the cultural essence of Vietnamese street culture into fashion products for the youth. BOO aspires to continue spreading the spirit of daring to think and daring to do through its 20th-anniversary collection'),
( 'Coins1', 'img\Coins1.jpg', 250000.00, 'áo sweater Coins', 2, NULL, 'The journey to conquer the streetwear scene by the DirtyCoins brand began in 2017 in Ho Chi Minh City - Vietnam, stemming from the idea of creating a Vietnamese brand that embodies street culture. The DirtyCoins journey commenced alongside passionate and creative Gen Z friends.'),
( 'Coins2', 'img\Coins2.jpg', 250000.00, 'áo sweater Coins', 2, NULL, 'The journey to conquer the streetwear scene by the DirtyCoins brand began in 2017 in Ho Chi Minh City - Vietnam, stemming from the idea of creating a Vietnamese brand that embodies street culture. The DirtyCoins journey commenced alongside passionate and creative Gen Z friends.'),
( 'Coins3', 'img\Coins3.jpg', 500000.00, 'áo khoác Coins', 2, NULL, 'The journey to conquer the streetwear scene by the DirtyCoins brand began in 2017 in Ho Chi Minh City - Vietnam, stemming from the idea of creating a Vietnamese brand that embodies street culture. The DirtyCoins journey commenced alongside passionate and creative Gen Z friends.'),
( 'Coins4', 'img\Coins4.jpg', 150000.00, 'áo thun Coins', 2, NULL, 'The journey to conquer the streetwear scene by the DirtyCoins brand began in 2017 in Ho Chi Minh City - Vietnam, stemming from the idea of creating a Vietnamese brand that embodies street culture. The DirtyCoins journey commenced alongside passionate and creative Gen Z friends.'),
( 'Coins5', 'img\Coins5.jpg', 250000.00, 'áo sweater Coins', 2, NULL, 'The journey to conquer the streetwear scene by the DirtyCoins brand began in 2017 in Ho Chi Minh City - Vietnam, stemming from the idea of creating a Vietnamese brand that embodies street culture. The DirtyCoins journey commenced alongside passionate and creative Gen Z friends.'),
( 'Coins6', 'img\Coins6.jpg', 150000.00, 'áo thun Coins', 2, NULL, 'The journey to conquer the streetwear scene by the DirtyCoins brand began in 2017 in Ho Chi Minh City - Vietnam, stemming from the idea of creating a Vietnamese brand that embodies street culture. The DirtyCoins journey commenced alongside passionate and creative Gen Z friends.'),
( 'Lemon3', 'img\Lemon3.jpg', 160000.00, 'áo sweater Lemon', 3, 2, 'Drawing inspiration from the youth, continuous creativity, keeping up with trends, and developing diverse product lines are the ways we operate to shape your daily lifestyle. Lemons goal is to provide high-quality fashion products at reasonable prices'),
('Lemon4', 'img\Lemon4.jpg', 160000.00, 'so mi Lemon', 3, 2, 'Drawing inspiration from the youth, continuous creativity, keeping up with trends, and developing diverse product lines are the ways we operate to shape your daily lifestyle. Lemons goal is to provide high-quality fashion products at reasonable prices'),
( 'Lemon5', 'img\Lemon5.jpg', 120000.00, 'áo thun Lemon', 3, 2, 'Drawing inspiration from the youth, continuous creativity, keeping up with trends, and developing diverse product lines are the ways we operate to shape your daily lifestyle. Lemons goal is to provide high-quality fashion products at reasonable prices'),
( 'Teelab1', 'img\Teelab1.jpg', 100000.00, 'áo thun Teelab', 4, NULL, 'Not just fashion, TEELAB is also the "laboratory" of youth - a place for research and the birth of energy called "Youth". We always aim to create joyful, dynamic, and youthful experiences.'),
('Teelab2', 'img\Teelab2.jpg', 100000.00, 'áo thun Teelab', 4, NULL, 'Not just fashion, TEELAB is also the "laboratory" of youth - a place for research and the birth of energy called "Youth". We always aim to create joyful, dynamic, and youthful experiences.'),
( 'Teelab3', 'img\Teelab3.jpg', 100000.00, 'áo thun Teelab', 4, NULL, 'Not just fashion, TEELAB is also the "laboratory" of youth - a place for research and the birth of energy called "Youth". We always aim to create joyful, dynamic, and youthful experiences.'),
( 'Teelab4', 'img\Teelab4.jpg', 120000.00, 'áo thun Teelab', 4, NULL, 'Not just fashion, TEELAB is also the "laboratory" of youth - a place for research and the birth of energy called "Youth". We always aim to create joyful, dynamic, and youthful experiences.'),
( 'Teelab5', 'img\Teelab5.jpg', 160000.00, 'áo thun Teelab', 4, NULL, 'Not just fashion, TEELAB is also the "laboratory" of youth - a place for research and the birth of energy called "Youth". We always aim to create joyful, dynamic, and youthful experiences.'),
( 'Teelab6', 'img\Teelab6.jpg', 180000.00, 'áo thun Teelab', 4, NULL, 'Not just fashion, TEELAB is also the "laboratory" of youth - a place for research and the birth of energy called "Youth". We always aim to create joyful, dynamic, and youthful experiences.');