CREATE SCHEMA IF NOT EXISTS util_sch;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.order_item_data
(
    id                   uuid DEFAULT uuid_generate_v4(),
    order_id                  uuid NOT NULL,
    product_id                uuid NOT NULL,
    order_product_unit_price  DOUBLE PRECISION NOT NULL,
    quantity                  int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES util_sch.order_data(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES util_sch.product_data(id) ON DELETE CASCADE
);