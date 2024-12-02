ALTER TABLE util_sch.customer_data
    ADD CONSTRAINT fk_cart
        FOREIGN KEY (cart_id) REFERENCES util_sch.cart_data(id) ON DELETE CASCADE;

ALTER TABLE util_sch.cart_data
    ADD CONSTRAINT fk_customer
        FOREIGN KEY (customer_id) REFERENCES util_sch.customer_data(id) ON DELETE CASCADE;