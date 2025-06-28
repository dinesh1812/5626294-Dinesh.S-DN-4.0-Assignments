-- Create Accounts table
CREATE TABLE customers (
    customer_id     NUMBER PRIMARY KEY,
    customer_name   VARCHAR2(100),
    city            VARCHAR2(50),
    last_modified   DATE
);

-- Insert Data
INSERT INTO customers VALUES (1, 'Alice', 'Chennai', SYSDATE - 1);
INSERT INTO customers VALUES (2, 'Bob', 'Delhi', SYSDATE - 1);
INSERT INTO customers VALUES (3, 'Charlie', 'Mumbai', SYSDATE - 1);
INSERT INTO customers VALUES (4, 'Dinesh', 'Kolkata', SYSDATE - 1);

COMMIT;

-- Display Data
SELECT * FROM customers;

-- Create Trigger
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON customers
FOR EACH ROW
BEGIN
    :NEW.last_modified := SYSDATE;
END;
/

-- Update Data and Test Trigger
UPDATE customers
SET city = 'Pune'
WHERE customer_id = 2;