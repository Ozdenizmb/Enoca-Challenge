CREATE SCHEMA IF NOT EXISTS util_sch;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS util_sch.product_data
(
    id                   uuid DEFAULT uuid_generate_v4(),
    name                      VARCHAR NOT NULL,
    description               VARCHAR NOT NULL,
    price                     DOUBLE PRECISION NOT NULL,
    stock                     INT NOT NULL,
    category                  VARCHAR NOT NULL,
    brand                     VARCHAR NOT NULL,
    created_date              DATE NOT NULL,
    updated_date              DATE NOT NULL,
    PRIMARY KEY (id)
);