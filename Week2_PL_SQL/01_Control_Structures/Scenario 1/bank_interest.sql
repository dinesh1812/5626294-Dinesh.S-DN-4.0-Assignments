-- Create Table
CREATE TABLE customers(
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER,
    loan_amount NUMBER(10,2),
    interest_rate NUMBER(5,2)
);

-- Display table to view the values
SELECT * FROM customers;

-- Insert data
INSERT INTO customers VALUES (1, 'Ravi Kumar', 65, 500000, 7.5);
INSERT INTO customers VALUES (2, 'Sneha Rao', 45, 300000, 8.0);
INSERT INTO customers VALUES (3, 'Anil Mehta', 70, 700000, 7.0);
INSERT INTO customers VALUES (4, 'Meena Joshi', 58, 200000, 9.0);
INSERT INTO customers VALUES (5, 'Karan Patel', 62, 600000, 7.8);

COMMIT;

-- PL SQL Block
BEGIN
    FOR customer IN (SELECT customer_id , interest_rate from customers where age > 60) LOOP
        UPDATE customers
        SET interest_rate = interest_rate - 1
        WHERE customer_id = customer.customer_id;
    END LOOP;

    COMMIT;
END;
/
