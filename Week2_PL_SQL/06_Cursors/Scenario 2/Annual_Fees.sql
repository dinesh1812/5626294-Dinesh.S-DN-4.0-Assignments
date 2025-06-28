-- Create Table
CREATE TABLE accounts (
    account_id      NUMBER PRIMARY KEY,
    customer_name   VARCHAR2(100),
    balance         NUMBER(12,2)
);

-- Insert Data
INSERT INTO accounts VALUES (1, 'Alice', 10000);
INSERT INTO accounts VALUES (2, 'Bob', 7500);
INSERT INTO accounts VALUES (3, 'Charlie', 3000);

COMMIT;

-- Display Data
SELECT * FROM accounts;

-- Declare Cursor
DECLARE
    CURSOR acc_cursor IS
        SELECT account_id, balance from accounts;
    v_acc_id accounts.account_id%TYPE;
    v_balance accounts.balance%TYPE;
    v_fees CONSTANT NUMBER := 500;
BEGIN
    OPEN acc_cursor;
    LOOP
        FETCH acc_cursor INTO v_acc_id, v_balance;
        EXIT WHEN acc_cursor%NOTFOUND;

        UPDATE accounts
        set balance = balance - v_fees
        WHERE account_id = v_acc_id;
        DBMS_OUTPUT.PUT_LINE('Fee of Rs.' || v_fees || ' applied to Account ID: ' || v_acc_id);
    END LOOP;
    CLOSE acc_cursor;

    COMMIT;
END;
/