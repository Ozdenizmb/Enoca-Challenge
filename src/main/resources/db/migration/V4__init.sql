CREATE SCHEMA IF NOT EXISTS util_sch;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.cart_item_data
(
    id                   uuid DEFAULT uuid_generate_v4(),
    cart_id                   uuid NOT NULL,
    product_id                uuid NOT NULL,
    quantity                  int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cart_id) REFERENCES util_sch.cart_data(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES util_sch.product_data(id) ON DELETE CASCADE
);