-- Create Table
CREATE TABLE customers (
    customer_id    NUMBER PRIMARY KEY,
    customer_name  VARCHAR2(100),
    city           VARCHAR2(50)
);

-- Insert Data
BEGIN
    AddNewCustomer(1001, 'Dinesh S', 'Chennai'); 
    AddNewCustomer(1001, 'Dinesh Copy', 'Delhi'); -- Duplicate data
END;

-- Display Data
SELECT * FROM customers;

-- Create Procedure
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id   IN NUMBER,
    p_customer_name IN VARCHAR2,
    p_city          IN VARCHAR2
) AS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM customers
    WHERE customer_id = p_customer_id;

    IF v_count > 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customer_id || ' already exists.');
        RETURN;
    END IF;

    -- Insert new customer
    INSERT INTO customers (customer_id, customer_name, city)
    VALUES (p_customer_id, p_customer_name, p_city);

    DBMS_OUTPUT.PUT_LINE('Customer ' || p_customer_name || ' added successfully.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/