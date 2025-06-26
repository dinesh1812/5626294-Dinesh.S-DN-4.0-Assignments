-- Create Table
CREATE TABLE loans(
    loan_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100),
    due_date DATE
);

-- Insert Table data
INSERT INTO loans VALUES (1, 'Ravi Kumar', TO_DATE('2025-07-10', 'YYYY-MM-DD'));
INSERT INTO loans VALUES (2, 'Sneha Rao', TO_DATE('2025-08-15', 'YYYY-MM-DD'));
INSERT INTO loans VALUES (3, 'Anil Mehta', TO_DATE('2025-06-30', 'YYYY-MM-DD'));
INSERT INTO loans VALUES (4, 'Meena Joshi', TO_DATE('2025-06-25', 'YYYY-MM-DD'));
INSERT INTO loans VALUES (5, 'Karan Patel', TO_DATE('2025-07-20', 'YYYY-MM-DD'));

COMMIT;

-- Display Table Values
SELECT * FROM loans;

-- Pl SQL Block to fetch all the loan dues within next 30 days 
-- And print a remainder message

BEGIN
    FOR loan IN (
        SELECT loan_id, customer_name, due_date
        from loans
        where due_date BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Remainder: Loan ID - ' || loan.loan_id || ' for ' || loan.customer_name || ' is due on ' || TO_CHAR(loan.due_date,'DD-MM-YYYY'));
    END LOOP;
END;
/
