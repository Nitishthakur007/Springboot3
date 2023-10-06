Insert into category (categoryName) values
('Fashion'),
('Electronics'),
('Books'),
('Groceries'),
('Medicines');



Insert into product (productName, price,categoryId) values
('Apple iPad 10.2 8th Gen WIFI iOS Tablet', 29190.00, 2),
('Crocin pain relief tablet', 10.00, 5);


Insert into user_table (username, password) values
('jack', 'pass_word'),
('bob','pass_word'),
('apple', 'pass_word'),
('glaxo', 'pass_word');


Insert into cart (totalAmount,userId) values
(20, 1),
(0, 2);

Insert into cartproduct (productId, quantity, cartId) values
(2, 2, 1);

Insert into role (role) values
('CONSUMER'),
('SELLER');


update user_table
SET roleId = 1
Where userId = 1;

update user_table
SET roleId = 2
Where userId = 3;