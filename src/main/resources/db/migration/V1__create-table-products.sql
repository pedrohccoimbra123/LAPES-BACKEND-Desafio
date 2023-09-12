CREATE TABLE products(
    id SERIAL PRIMARY KEY NOT NULL,
    category TEXT NOT NULL,
    product_name TEXT NOT NULL,
    price FLOAT NOT NULL,
    unitSold INTEGER NOT NULL
);