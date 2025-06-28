-- Create Table
CREATE TABLE customers (
    customer_id    NUMBER PRIMARY KEY,
    customer_name  VARCHAR2(100),
    date_of_birth  DATE
);

-- Insert Data
INSERT INTO customers VALUES (1, 'Dinesh S', DATE '2000-06-26');
INSERT INTO customers VALUES (2, 'Ravi K', DATE '1995-12-10');

COMMIT;

-- Display Data
SELECT * from customers;

-- Create Function
CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER
IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error calculating age: ' || SQLERRM);
        RETURN NULL;
END;
/

-- Execute Function
DECLARE
    v_age NUMBER;
BEGIN
    v_age := CalculateAge(DATE '2000-06-26'); -- Example DOB
    DBMS_OUTPUT.PUT_LINE('Age: ' || v_age);
END;
/