-- Create table
CREATE TABLE loans (
    loan_id       NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100),
    loan_amount   NUMBER(12,2),
    interest_rate NUMBER(5,2)  -- Annual interest rate in %
);

-- Insert data
INSERT INTO loans VALUES (1, 'Alice', 500000, 7.5);
INSERT INTO loans VALUES (2, 'Bob', 300000, 6.8);
INSERT INTO loans VALUES (3, 'Charlie', 800000, 9.2);

COMMIT;

-- Display data
SELECT * FROM loans;

-- Declare Cursor
DECLARE
    CURSOR loan_cursor IS
        SELECT loan_id, interest_rate FROM loans;

    v_loan_id       loans.loan_id%TYPE;
    v_interest_rate loans.interest_rate%TYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_interest_rate;
        EXIT WHEN loan_cursor%NOTFOUND;

        UPDATE loans
        SET interest_rate = v_interest_rate - 0.5
        WHERE loan_id = v_loan_id;

        DBMS_OUTPUT.PUT_LINE('Interest rate updated for Loan ID: ' || v_loan_id);
    END LOOP;
    CLOSE loan_cursor;

    COMMIT;
END;
/