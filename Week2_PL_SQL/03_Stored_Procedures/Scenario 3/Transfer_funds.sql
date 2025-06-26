-- Create Table
CREATE TABLE accounts (
    account_id     NUMBER PRIMARY KEY,
    customer_name  VARCHAR2(100),
    balance        NUMBER(12,2)
);

-- Insert Data
INSERT INTO accounts VALUES (201, 'Dinesh S', 15000);
INSERT INTO accounts VALUES (202, 'Ravi K', 8000);
INSERT INTO accounts VALUES (203, 'Priya R', 5000);

COMMIT;

-- Display Data
SELECT * FROM accounts;

-- Create Procedure
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance
    from accounts
    where account_id = p_from_account;

    IF v_balance < p_amount THEN
    DBMS_OUTPUT.PUT_LINE('Insufficient balance in the Sender account');
    RETURN;
    END IF;

    -- Send Fund
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account;

    -- Recieve Fund
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account;
    DBMS_OUTPUT.PUT_LINE('Transfer of Rs.' || p_amount || ' from Account ' || p_from_account || ' to Account ' || p_to_account || ' successful.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('One or both accounts not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

-- Execute Procedure
BEGIN
    TransferFunds(201, 202, 3000);  -- Transfer Rs.3000 from A/C 201 to 202
END;
/