-- Create Table
CREATE TABLE customers(
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    balance NUMBER(10,2),
    is_vip NUMBER(1) DEFAULT 0
);

-- Inset Values
INSERT INTO customers VALUES (1, 'Ravi Kumar', 9500.00, 0);
INSERT INTO customers VALUES (2, 'Sneha Rao', 12000.00, 0);
INSERT INTO customers VALUES (3, 'Anil Mehta', 10500.50, 0);
INSERT INTO customers VALUES (4, 'Meena Joshi', 8700.75, 0);
INSERT INTO customers VALUES (5, 'Karan Patel', 20000.00, 0);

COMMIT;

-- Display the table data
SELECT * FROM customers;

BEGIN
    FOR customer IN (SELECT customer_id , balance from customers where balance > 10000) LOOP
        UPDATE customers
        set IS_VIP = 1
        where customer_id = customer.customer_id;
    END LOOP;

    COMMIT;
END;
/