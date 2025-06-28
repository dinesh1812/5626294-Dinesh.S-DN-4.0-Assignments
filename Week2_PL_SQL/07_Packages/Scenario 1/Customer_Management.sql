-- Create table
CREATE TABLE CUSTOMER (
    customer_id      NUMBER PRIMARY KEY,
    name             VARCHAR2(100),
    email            VARCHAR2(100),
    phone            VARCHAR2(15),
    balance          NUMBER(10, 2)
);

--  Insert Data
INSERT INTO CUSTOMER VALUES (1, 'Dinesh', 'dinesh@example.com', '9876543210', 15000);
INSERT INTO CUSTOMER VALUES (2, 'Suresh', 'suresh@example.com', '9123456789', 23000);
INSERT INTO CUSTOMER VALUES (3, 'Vanitha', 'vanitha@example.com', '9001122334', 5000);

COMMIT;

-- Display Data
SELECT * FROM customer;

-- Create Package Structure
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(
        p_id     IN NUMBER,
        p_name   IN VARCHAR2,
        p_email  IN VARCHAR2,
        p_phone  IN VARCHAR2,
        p_balance IN NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_id     IN NUMBER,
        p_name   IN VARCHAR2,
        p_email  IN VARCHAR2,
        p_phone  IN VARCHAR2
    );

    FUNCTION GetBalance(p_id IN NUMBER) RETURN NUMBER;
END CustomerManagement;

-- Create Procedure Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_id     IN NUMBER,
        p_name   IN VARCHAR2,
        p_email  IN VARCHAR2,
        p_phone  IN VARCHAR2,
        p_balance IN NUMBER
    ) IS
    BEGIN
        INSERT INTO CUSTOMER (customer_id, name, email, phone, balance)
        VALUES (p_id, p_name, p_email, p_phone, p_balance);
    END AddCustomer;

    PROCEDURE UpdateCustomer(
        p_id     IN NUMBER,
        p_name   IN VARCHAR2,
        p_email  IN VARCHAR2,
        p_phone  IN VARCHAR2
    ) IS
    BEGIN
        UPDATE CUSTOMER
        SET name = p_name,
            email = p_email,
            phone = p_phone
        WHERE customer_id = p_id;
    END UpdateCustomer;

    FUNCTION GetBalance(p_id IN NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT balance INTO v_balance
        FROM CUSTOMER
        WHERE customer_id = p_id;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN -1;
    END GetBalance;

END CustomerManagement;
/

-- Add a new customer
BEGIN
    CustomerManagement.AddCustomer(6, 'Sneha K', 'sneha@example.com', '9998887776', 30000);
END;
/

-- Update existing customer
BEGIN
    CustomerManagement.UpdateCustomer(2, 'Meera S Nair', 'meera.nair@example.com', '9123409876');
END;
/

-- Get balance of a customer
DECLARE
    bal NUMBER;
BEGIN
    bal := CustomerManagement.GetBalance(2);
    DBMS_OUTPUT.PUT_LINE('Balance: ' || bal);
END;
/