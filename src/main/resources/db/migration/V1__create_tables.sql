-- Creación de la tabla BRANDS
CREATE TABLE BRANDS (
                        BRAND_ID INT PRIMARY KEY,
                        NAME VARCHAR(32)
);

-- Creación de la tabla PRICES
CREATE TABLE PRICES (
                        PRICE_ID INT PRIMARY KEY AUTO_INCREMENT,
                        BRAND_ID INT,
                        START_DATE DATETIME,
                        END_DATE DATETIME,
                        PRICE_LIST INT,
                        PRODUCT_ID INT,
                        PRIORITY INT,
                        PRICE DECIMAL(10, 2),
                        CURR CHAR(3),
                        FOREIGN KEY (BRAND_ID) REFERENCES BRANDS(BRAND_ID)
);