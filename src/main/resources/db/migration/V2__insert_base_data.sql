-- Inserción de datos en la tabla BRANDS
INSERT INTO BRANDS(BRAND_ID, NAME) VALUES
(1, 'ZARA'),
(2, 'PULL&BEAR'),
(3, 'MASSIMODUTTI'),
(4, 'BERSHKA'),
(5, 'STRADIVARIUS'),
(6, 'OVSHO'),
(7, 'ZARAHOME'),
(8, 'UTERGUE');

-- Inserción de datos en la tabla PRICES
INSERT INTO PRICES (BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES
(1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
(1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
(1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
(1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR'),
(2, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 2, 35455, 1, 30.50, 'EUR'),
(2, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 2, 35455, 1, 38.95, 'EUR');