CREATE SCHEMA IF NOT EXISTS util_sch;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.cart_data
(
    id                   uuid DEFAULT uuid_generate_v4(),
    customer_id               uuid NOT NULL UNIQUE,
    total_price               DOUBLE PRECISION NOT NULL,
    created_date              DATE NOT NULL,
    updated_date              DATE NOT NULL,
    PRIMARY KEY (id)
);