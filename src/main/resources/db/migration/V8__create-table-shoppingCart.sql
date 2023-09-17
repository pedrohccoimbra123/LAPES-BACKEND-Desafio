CREATE TABLE shoppingCart(
    id BIGINT PRIMARY KEY,
    user_id BIGINT
);
ALTER TABLE shoppingCart
    ADD CONSTRAINT FK_user_id FOREIGN KEY (user_id)
    REFERENCES users(id);