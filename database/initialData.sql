INSERT INTO User(username, password, role, email) values('admin', 'admin', 'ADMIN', 'admin@admin.com');
INSERT INTO User(username, password, role, email) values('admin1', 'admin1', 'ADMIN', 'admin1@ad.com');

INSERT INTO User(username, password, email) values('smith', 'smith', 'smith@gmail.com');
INSERT INTO User(username, password, email) values('revanth', 'revanth', 'revanth@gmail.com');


-- Company --------------------------------------------------------------------------.
INSERT INTO Company(ID, name, description) values(1, 'Nokia', '');
INSERT INTO Company(ID, name, description) values(2, 'Samsung', '');
INSERT INTO Company(ID, name, description) values(3, 'Apple', '');
INSERT INTO Company(ID, name, description) values(4, 'Google', '');
INSERT INTO Company(ID, name, description) values(5, 'Lava', '');
INSERT INTO Company(ID, name, description) values(6, 'Karbon', '');

-- Products --------------------------------------------------------------------------.
-- Mobiles
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(1, 'Nokia Lumia 330', 'Nokia mobile', 'mobile', 10, 10000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(1, 'Nokia Lumia 430', 'Nokia mobile', 'mobile', 10, 20000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(1, 'Nokia Lumia 530', 'Nokia mobile', 'mobile', 10, 30000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(1, 'Nokia Lumia 630', 'Nokia mobile', 'mobile', 10, 40000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(1, 'Nokia Lumia 730', 'Nokia mobile', 'mobile', 10, 50000, 'INR');


INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType)
values(2, 'Samsung Galaxy  SI', 'Samsung mobile', 'mobile', 20, 10000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(2, 'Samsung Galaxy  SII', 'Samsung mobile', 'mobile', 120, 10000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(2, 'Samsung Galaxy  SIII', 'Samsung mobile', 'mobile', 20, 10000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(2, 'Samsung Galaxy  SIV', 'Samsung mobile', 'mobile', 40, 10000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(2, 'Samsung Galaxy  SV', 'Samsung mobile', 'mobile', 50, 10000, 'INR');

-- Television
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(2, 'Samsung TV 1200', 'Samsung mobile', 'tv', 20, 100000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(2, 'Samsung TV 1400', 'Samsung mobile', 'tv', 120, 200000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(2, 'Samsung TV 14500', 'Samsung mobile', 'tv', 20, 300000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(2, 'Samsung TV 123200', 'Samsung mobile', 'tv', 40, 140000, 'INR');
INSERT INTO Product(Company_ID, name, description, product_type, available_quantity, price, priceType) 
values(2, 'Samsung TV 1200 HD LED', 'Samsung mobile', 'tv', 50, 105000, 'INR');
