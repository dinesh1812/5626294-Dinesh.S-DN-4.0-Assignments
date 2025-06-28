-- Create Table
CREATE TABLE accounts (
    account_id     NUMBER PRIMARY KEY,
    customer_name  VARCHAR2(100),
    balance        NUMBER(12,2)
);

-- Insert Data
INSERT INTO accounts VALUES (301, 'Dinesh S', 20000);
INSERT INTO accounts VALUES (302, 'Ravi K', 10000);

COMMIT;

-- Display Data
SELECT * FROM accounts;

-- Create Procedure
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance
    FROM accounts
    WHERE account_id = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- 2. Deduct from source
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;

    -- 3. Credit to target
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Transfer of Rs.' || p_amount || ' successful.');
EXCEPTION -- Handles Error
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Account not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

-- Execute Procedure
BEGIN
    SafeTransferFunds(301, 302, 5000);
END;
/

-- Error handling
BEGIN
    SafeTransferFunds(301, 302, 999999); -- Throws Error
END;
/