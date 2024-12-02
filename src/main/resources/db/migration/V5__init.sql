CREATE SCHEMA IF NOT EXISTS util_sch;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.order_data
(
    id                   uuid DEFAULT uuid_generate_v4(),
    customer_id               uuid NOT NULL,
    total_price               DOUBLE PRECISION NOT NULL,
    created_date              DATE NOT NULL,
    updated_date              DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES util_sch.customer_data(id) ON DELETE CASCADE
);